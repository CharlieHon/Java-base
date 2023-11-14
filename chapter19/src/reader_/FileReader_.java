package reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "g:/story.txt";
        FileReader fileReader = null;
        int data = 0;
        try {
            // 1. 创建 FileReader对象
            fileReader = new FileReader(filePath);
            // 循环读取，使用read
            while ((data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void readFile02() {
        System.out.println("~~FileReader(char[])");
        String filePath = "g:/story.txt";
        FileReader fileReader = null;
        int dataLen = 0;
        char[] buf = new char[8];
        try {
            // 1. 创建 FileReader对象
            fileReader = new FileReader(filePath);
            // 循环读取，使用read(buf)，返回实际读取到的字符数
            while ((dataLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, dataLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

