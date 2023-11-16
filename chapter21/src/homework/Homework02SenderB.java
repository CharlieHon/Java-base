package homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8887);
        System.out.println("发送端B等待发送信息：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        byte[] data = s.getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);

        // 等待接收信息
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        data = packet1.getData();
        s = new String(data, 0, length);
        System.out.println("A > " + s);

        // 关闭资源
        socket.close();
        System.out.println("B端退出...");
    }
}
