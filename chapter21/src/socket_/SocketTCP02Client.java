package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端，返送 "hello, server" 给服务端
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务器（ip，端口）
        // 解读：连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket=" + socket.getClass());  // socket=class java.net.Socket
        // 2. 连接上后，生成Socket，通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();   // !得到和socket对象关联的输出流
        // 3. 通过输出流，写入数据到数据通道
        outputStream.write("hello, server".getBytes());

        // 设置结束标记
        socket.shutdownOutput();

        // 4. 获取和socket相关联的输入流
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int dataLen = 0;
        while ((dataLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, dataLen));
        }

        // 5. 关闭流对象和socket
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("发送成功，客户端退出...");
    }
}
