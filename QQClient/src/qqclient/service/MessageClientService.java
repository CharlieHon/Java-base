package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 该对象/类，提供和消息相关的服务方法
 */
public class MessageClientService {

    /***
     * 群发消息
     * @param content   消息内容
     * @param senderId  发送者
     */
    public void sendMessageToAll(String content, String senderId) {
        // 构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES); // 群发消息
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "：" + content);
        // 发送给所有人
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 向服务端发送信息
     * @param content   内容
     * @param senderId  发送用户Id
     * @param getterId  接收用户Id
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        // 构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + " > " + getterId + " : " + content);
        // 发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
