package inputstream_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        // 完成文件拷贝，将 e:/ikun.png 拷贝到 g:/
        /*
        1. 创建文件的输入流，将文件读入到程序
        2. 创建文件的输出流，将文件
         */
        String srcPath = "e:/ikun.png";
        String destPath = "g:/ikun.png";
        File srcFile = new File(srcPath);
        File destFIle = new File(destPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        int readLen = 0;
        byte[] buf = new byte[8];   // 定义一个字节数组，提高读取效果
        if (srcFile.exists()) {
            try {
                fileInputStream = new FileInputStream(srcFile);
                fileOutputStream = new FileOutputStream(destFIle);
                // 边读边写
                while ((readLen = fileInputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, readLen);    // write(buf)有可能出错
                }
                System.out.println("拷贝成功！");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    // 关闭输入流和输出流
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("文件不存在！");
        }
    }
}
