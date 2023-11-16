package socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server\n");
        bufferedWriter.write("收到请回复\n");
        // bufferedWriter.newLine();   // 插入一个换行，表示写入的内容结束，注意：要求对方使用readLine()！！
        bufferedWriter.flush(); // 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        socket.shutdownOutput();
        System.out.println("客户端发送完毕...");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] buf = new char[16];
        int dataLen = 0;
        while ((dataLen = bufferedReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, dataLen));
        }
        System.out.println("客户端接收完毕...");

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
