package upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        // 1. 在客户端连接服务端8888端口，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        // 2. 创建读取磁盘文件的输入流
        String filePath = "e:/ikun.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        // bytes就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        // 通过socket获取到输出流，将bytes数据发送到服务段
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);   // 将文件对应的字节数组的内容，写入到数据通道
        bos.flush();    // 写入数据后，需要刷新才真正写入，否则会报错 Cannot send after socket shutdown: socket write error
        bis.close();
        socket.shutdownOutput();    // 设置写入数据的结束标记

        // 接收从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        // 使用StreamUtils的方法，直接将inputStream读取到的内容转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        // 关闭相关流
        inputStream.close();
        bos.close();
        socket.close();
    }
}
