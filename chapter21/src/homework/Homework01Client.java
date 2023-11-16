package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Homework01Client { // A
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("请输入发送的消息：");
        String message = scanner.next();
        writer.write(message);  // 写入数据
        writer.newLine();   // 标识写入结束
        writer.flush(); // 刷新发送

        // 接收回复
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        System.out.println("B > " + s);

        // 关闭资源
        reader.close();
        writer.close();
        socket.close();
    }
}
