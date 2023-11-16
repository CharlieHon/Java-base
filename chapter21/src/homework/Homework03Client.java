package homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client { // 文件下载的客户端
    public static void main(String[] args) throws Exception {
        // 1. 客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 2. 接收用户输入，指定下载文件名
        System.out.println("请输入文件名：");
        Scanner scanner = new Scanner(System.in);
        String file = scanner.next();
        // 3. 获取和Socket相关的输出流，写入数据
        writer.write(file);
        writer.newLine();   // 结束标志，对应 readLine()
        writer.flush();

        System.out.println("正在下载...");
        // 4. 读取服务端返回的文件(字节数据)
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] data = StreamUtils.streamToByteArray(bis);
        // 5. 得到一个输出流，准备将 data 写入到磁盘
        String destPathName = "e:\\" + file + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPathName));
        bos.write(data);
        System.out.println("===下载完毕！===");

        // 6. 关闭相关资源
        bos.close();
        bis.close();
        writer.close();
        socket.close();
    }
}
