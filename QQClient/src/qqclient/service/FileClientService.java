package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.*;
import java.util.Date;

/**
 * 该类/对象完成 文件传输服务
 */
public class FileClientService {
    /***
     * 给他人传输文件
     * @param src   源文件
     * @param dest  目标目录/文件
     * @param senderId  发送用户Id
     * @param getterId  接收用户Id
     */
    public void sendFileToOne(String src, String dest, String senderId, String getterId) {
        // 1. 读取src文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);
        message.setSendTime(new Date().toString());

        // 2. 将文件读取
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);    // 将src文件读入到字节数组
            // 将文件对应的字节数组放入message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // 提示信息
        System.out.println("\n" + message.getSendTime() + "\n" + senderId + "(" + src + ")" +
                ">>>file>>>" + getterId + "(" + dest + ")");
        // 发送
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
