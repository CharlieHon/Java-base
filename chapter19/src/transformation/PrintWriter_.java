package transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    // 演示PrintWriter使用方式
    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:/f1.txt")); // 自定义打印位置
        printWriter.println("你好");
        printWriter.close();    // 不关闭流，不会真正输出内容的！ flush + 关闭流，才会将数据写入到文件
    }
}
