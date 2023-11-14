package writer_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void fileWriter01() {
        String filePath = "g:/story.txt";
        FileWriter fileWriter = null;
        char[] chs = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write('H');  // 写入一个字符
            fileWriter.write(chs);  // 写入字符数组
            fileWriter.write("自由平等".toCharArray(), 0, 2);
            fileWriter.write("人民万岁");
            fileWriter.write("北上广深", 0, 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 对于FileWriter，一定要关闭流，或者flush才能真正把数据写入到文件
                fileWriter.close(); // 关闭文件流，等价于 flush() + 关闭
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("程序结束~");
    }
}
