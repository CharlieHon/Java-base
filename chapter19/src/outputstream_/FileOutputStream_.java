package outputstream_;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示使用 FileOutputStream 将数据写到文件中
     * 如果文件不存在，则创建文件
     */
    @Test
    public void writeFile() {
        // 创建 FileOutputStream 对象
        String filePath = "e:/a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            // 得到一个对象
            fileOutputStream = new FileOutputStream(filePath);
            /*
            1. new FileOutputStream(filePath)：创建方式，当写入内容时，会覆盖原来内容
            2. new FileOutputStream(filePath, true)：当写入内容时，是追加到文件后面
             */
            // 写入一个字节
            fileOutputStream.write('H');
            // 写入字符串
            String str = "hello,world!";
            fileOutputStream.write(str.getBytes()); // getBytes()方法可以将 String -> byte[]
            // 写入字符串
            fileOutputStream.write(str.getBytes(), 0, 5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
