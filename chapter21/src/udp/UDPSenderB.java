package udp;

import java.io.IOException;
import java.net.*;

/**
 * UDP发送端B ===> 也可以接收数据
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 1. 创建DatagramSocket对象，准备发送和接收数据，准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        // 2. 将需要发送的数据，封装到DatagramPacket对象中
        byte[] data = "hello 明天吃火锅~".getBytes();
        // 说明：封装的 DatagramPacket对象 data内容字节数组，data.length, 主机(IP), 端口号
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);

        // 3. 接收从A段回复的信息
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
        socket.receive(packet1);    // 接收
        data = packet1.getData();
        int length = packet1.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);

        // 关闭资源
        socket.close();
        System.out.println("发送端B退出...");
    }
}
