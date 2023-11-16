package udp;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP接收端A
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 1. 创建一个DatagramSocket对象，准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        // 2. 构建一个DatagramPacket对象，准备接收数据
        //      UDP协议接收数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        // 3. 调用接收方法，将通过网络传输的 DatagramPacket对象填充到 packet对象
        //  当有数据发送到本机的9999端口时，就会接收到数据包
        //  没有数据时，就会阻塞等待
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);
        // 4. 把packet数据进行拆包，取出数据并显示
        int length = packet.getLength();    // 实际接收到的数据的字节长度
        byte[] data = packet.getData();     // 接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);

        // ====回复B端信息
        data = "好的，明天见~".getBytes();
        DatagramPacket packet1 = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet1);

        // 5. 关闭资源
        socket.close();
        System.out.println("接收端A退出...");
    }
}
