package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 服务器推送消息的线程
 */
public class SendNewsToAllService extends Thread {

    @Override
    public void run() {
        // 为了可以推送多次新闻，使用while
        while (true) {
            System.out.println("请输入服务器要推送的消息/新闻[输入exit退出推送服务]：");
            String news = Utility.readString(100);
            if ("exit".equals(news)) {
                break;
            }
            // 构建一个消息，群发消息
            Message message = new Message();
            message.setSender("服务器");
            message.setSendTime(new Date().toString());
            message.setContent(news);
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            System.out.println("服务器推送：\n" + news);

            // 遍历当前所有的通讯线程，得到socket，并发送message
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iter = hm.keySet().iterator();
            while (iter.hasNext()) {
                String onlineUserId = iter.next();
                ServerConnectClientThread serverConnectClientThread = hm.get(onlineUserId);
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
