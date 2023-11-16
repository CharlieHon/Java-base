package socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * ServerSocket可以创建很多Socket
 * 每次调用accept()方法都会创建一个Socket对象
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        // 1. 在本机的9999端口监听，等待链接
        //      细节：要求在本机没有其它服务在监听9999端口
        //      细节：ServerSocket可以通过accept()返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");
        // 2. 如果没有客户端连接9999端口时，程序会阻塞，等待连接
        //      如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("socket=" + socket.getClass());  // socket=class java.net.Socket
        // 3. 通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();
        // 4. IO读取
        byte[] b = new byte[1024];
        int dataLen = 0;
        while ((dataLen = inputStream.read(b)) != -1) {
            System.out.println(new String(b, 0, dataLen));  // 根据读取到的实际长度，显示内容
        }

        // 5. 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());

        // 设置结束标记
        socket.shutdownOutput();

        // 6. 关闭流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();   // 关闭ServerSocket对象
    }
}
