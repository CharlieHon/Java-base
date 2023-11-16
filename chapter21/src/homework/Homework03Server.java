package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server { // 文件下载的服务端
    public static void main(String[] args) throws Exception {
        // 1. 监听9999端口，等待客户端连接，并发送下载文件的名字
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待接收信息...");
        // 2. 等待客户端连接
        Socket socket = serverSocket.accept();
        // 3. 读取客户端发送要下载的文件名
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        String filePathName = "src\\";
        if ("高山流水".equals(s)) {
            filePathName += "高山流水.mp3";
        } else {
            filePathName += "无名.mp3";
        }
        System.out.println("接收到客户端需要下载的文件名：" + filePathName);

        // 4. 创建一个输入流，读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePathName));
        // 5. 使用工具类StreamUtils，读取文件到一个byte[]字节数组
        byte[] data = StreamUtils.streamToByteArray(bis);
        // 6. 得到Socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        // 7. 写入到数据通道，返回给客户端
        bos.write(data);
        socket.shutdownOutput();    // 结束标记，很关键！
        // 8. 关闭相关资源
        bos.close();
        bis.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
