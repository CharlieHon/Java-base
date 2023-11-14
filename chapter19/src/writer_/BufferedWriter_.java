package writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) {
        // 使用BufferedWriter将 "hello，韩顺平教育"，写入到文件中
        String filePath = "g:/story.txt";
        BufferedWriter bufferedWriter = null;
        try {
            // 1. 在节点流上，设置以增加的方式写入
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write("hello，韩顺平教育");
            bufferedWriter.newLine();   // 插入一个和系统相关换行
            bufferedWriter.write("hello，韩顺平教育");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close(); // 关闭包装流，传入的 new FileWriter() 会在底层自动关闭
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
