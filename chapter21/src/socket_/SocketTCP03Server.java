package socket_;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端准备接收...");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        // 使用字符流读取，使用转换流将InputStream转换位字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] buf = new char[16];
        int dataLen = 0;
        while ((dataLen = bufferedReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, dataLen));
        }
        System.out.println("服务端接收完毕");

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client\n");
        bufferedWriter.write("继续加油\n");
        bufferedWriter.flush(); // 需要手动刷新
        socket.shutdownOutput();
        System.out.println("服务端发送完毕");

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
