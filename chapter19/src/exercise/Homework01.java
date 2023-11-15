package exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:/mytemp";
        String fileName = "hello.txt";
        File dir = new File(filePath);
        if(!dir.exists()) {
            dir.mkdir();
            System.out.println("目录创建成功~");
        }
        File file = new File(filePath, fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (file.exists()) {
            System.out.println(file.getName() + "已存在");
            fileOutputStream.write("hello,world~".getBytes());
            fileOutputStream.close();
            System.out.println("成功写入内容~");
        } else {
            file.createNewFile();
            System.out.println(file.getName() + "创建成功~");
        }
    }
}
