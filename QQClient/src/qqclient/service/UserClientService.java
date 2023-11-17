package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {
    // 因为可能在其它敌方使用user信息，因此做成成员属性
    private User u = new User();
    // 因为socket在其它地方也可能使用，因此作为属性
    private Socket socket;

    // 根据UserId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        // 创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        try {
            // 连接到服务端，发送u对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            // 等到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); // 发送User对象

            // 读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {    // 登录成功
                // 创建一个和服务器端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                // 启动客户端的线程
                clientConnectServerThread.start();
                // 为了后面客户端的扩张，将线程放入到集合管理
                ManageClientServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                b = true;
            } else {
                // 登录失败，就不能启动和服务器通信的线程，关闭socket
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    // 向服务端请求在线用户列表
    public void onlineFriendList() {
        // 发送一个Message，类型 MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        // 发送给服务器
        try {
            /*
            ManageClientServerThread.getClientConnectServerThread(u.getUserId())
                从管理线程的集合中，通过userId，得到这个线程对象
            getSocket() 通过线程得到线程关联/管理的socket
            getOutputStream() 得到socket关联的输出流
             */
            // 应该得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);   // 发送一个Message对象，向服务器请求在线用户列表
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 编写方法，退出客户端，并给服务端发送一个退出系统的message对象
    public void logout() {
        Message message = new Message();
        message.setSender(u.getUserId());   // 指定退出的客户端
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);

        // 发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统");
            System.exit(0); // 结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
