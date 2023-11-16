package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("===接收端A等待接收信息===");
        socket.receive(packet);
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println("B > " + s);
        String message = null;

        if ("四大名著有哪些".equals(s)) {  // 判断接收到的信息是什么
            message = "三国演义，水浒传，红楼梦，西游记";
        } else {
            message = "发生什么事了？";
        }

        data = message.getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8887);
        socket.send(packet1);

        // 关闭资源
        socket.close();
        System.out.println("A端退出...");
    }
}
