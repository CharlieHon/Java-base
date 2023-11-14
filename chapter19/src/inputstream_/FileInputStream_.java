package inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {
        // 演示 FileInputStream使用(字节输入六，文件->程序)

    }

    @Test
    public void readFile01() {  // 演示读取文件，FileInputStream：单个字节读取，效率较低
        String filePath = "e:/hello.txt";
        int read = 0;
        FileInputStream fileInputStream = null;
        try {
            // 创建 FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // 从该输入读取一个字节的数据，如果没有输入可用，此方法将阻止
            // 如果达到文件的末尾，返回 -1
            while ((read = fileInputStream.read()) != -1) {
                System.out.print((char)read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 使用read(byte[] b)提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:/hello.txt";
        int readLen = 0;
        // 字节数组
        byte[] buf = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            // 创建 FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // 从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            // 如果达到文件的末尾，返回 -1
            // 如果读取正常，返回实际读取的字节数
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭文件，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

