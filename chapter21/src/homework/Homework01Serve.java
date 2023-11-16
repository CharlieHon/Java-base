package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Serve {  // B
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待接收信息...");
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();   // readLine对应接收信息
        System.out.println("A > " + s);
        String message = null;
        if ("name".equals(s)) {
            message = "Charlie";
        } else if ("hobby".equals(s)) {
            message = "Java";
        } else {
            message = "How dare you!";
        }

        // 回复信息
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(message);
        writer.newLine();
        writer.flush();

        // 关闭资源
        writer.close();
        reader.close();
        socket.close();
    }
}
