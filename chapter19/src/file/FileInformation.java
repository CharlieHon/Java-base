package file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }
    // 获取文件的信息
    @Test
    public void info() {
        // 先创建文件对象
        File file = new File("e:/news1.txt");
        // 调用相应的方法，得到对应信息
        System.out.println("文件名：" + file.getName());    // 文件名：news1.txt
        System.out.println("绝对路径：" + file.getAbsolutePath());   // 绝对路径：e:\news1.txt
        System.out.println("文件父目录：" + file.getParent());    // 文件父目录：e:\
        System.out.println("文件大小(字节)：" + file.length());    // 11 utf-8:英文字母(1)，中文汉字(3)
        System.out.println("文件是否存在：" + file.exists());  // true
        System.out.println("是不是一个文件：" + file.isFile()); // true
        System.out.println("是不是一个目录：" + file.isDirectory());    // false
    }
}
