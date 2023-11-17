package qqserver.service;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 该类的一个对象和某个客户端保持通信，通讯线程
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;  // 连接到服务端的用户Id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        // 这里线程处于run的状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端 (用户：" + userId + ") 保持通讯，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // 根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 客户端要在线用户列表
                    /*
                    在线用户列表形式 100 200 至尊宝
                     */
                    System.out.println(message.getSender() + " 请求在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    // 构建Message对象并返回给客户端
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());
                    // 写入到数据通道，返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    // 根据message获取getterId，然后再得到对应的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    // 得到对应socket的对象输出流，将message对象转发给指定的客户端
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);   // 注意：如果客户不在线，可以保存到数据库，这样就可以实现离线
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 退出");
                    // 将这个线程从集合中删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    // 关闭该线程持有的socket
                    socket.close();
                    // 退出循环
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {   // 处理群发信息
                    String senderId = message.getSender();
                    // 需要遍历 管理线程的集合，把所有的线程的socket得到，然后把message转发
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iter = hm.keySet().iterator();
                    while (iter.hasNext()) {
                        // 取出在线用户id
                        String onlineUserId = iter.next();
                        if (!onlineUserId.equals(senderId)) {   // 群发给除自己以外的在线用户
                            // 进行转发
                            ObjectOutputStream oos = new ObjectOutputStream
                                    (hm.get(onlineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else {
                    System.out.println("其它类型message，暂时不处理");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
