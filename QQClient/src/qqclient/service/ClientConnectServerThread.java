package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    // 该线程需要持有Socket
    private Socket socket;

    // 构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 因为Thread需要在后台和服务器通信，因此使用while循环
        while (true) {
            try {
                System.out.println("客户端线程，等待从服务器发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送Message对象，线程会阻塞
                Message message = (Message) ois.readObject();
                // 判断message类型，然后做相应的业务处理
                // 如果读取到的是 服务端返回的在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    // 取出在线列表信息，并显示
                    String[] onlineUsers = message.getContent().split(" "); // 规定是返回数据是用空格隔开
                    System.out.println("\n========当前在线用户列表========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES )) {
                    // 接收的是普通的消息内容，直接显示到控制台即可
                    System.out.println("\n" + message.getSendTime() + "\n" + message.getSender() + " > " + message.getGetter()
                                    + " : " + message.getContent());
                } else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    // 显示群发消息
                    System.out.println("\n" + message.getSendTime() + "\n" +
                            message.getSender() + " : " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) { // 如果是文件消息
                    System.out.println("\n" + message.getSendTime() + "\n" + message.getSender() + "(" + message.getSrc() + ")" +
                            ">>>file>>>" + message.getGetter() + "(" + message.getDest() + ")");
                    // 取出message的文件字节数组，通过文件输出流写出到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("保存文件成功~");
                } else {
                    System.out.println("是其它类型的message，暂时不做处理...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 为了更方便的得到Socket，提高get/set方法
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
