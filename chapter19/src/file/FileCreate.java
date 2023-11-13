package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    // 方式1： new File(String pathname)
    // 方式2： new File(File parent, String child) // 根据父目录文件+子路径创建
    // 方式3： new File(String parent, String child)   // 根据父目录+子路径
    @Test
    public void create() {
//        String filePath = "e:\\news1.txt";
        // 方式1
//        File file = new File(filePath);
        // 方式2
//        File parentFile = new File("e:\\");
//        String fileName = "news2.txt";
//        File file = new File(parentFile, fileName); // 这里的file对象，在java程序中，只是一个对象
        // 方式3
        String parentPath = "E:\\";
        String filePath = "news3.txt";
        File file = new File(parentPath, filePath);
        try {
            file.createNewFile();   // 只有执行了createNewFile方法，才会真正地在磁盘创建该文件
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
