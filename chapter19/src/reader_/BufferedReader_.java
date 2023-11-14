package reader_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) {
        String filePath = "g:/story.txt";
        // 创建bufferedReader对象
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            // 读取
            String line;    // 按行读取，效率高
            // 1. bufferedReader.readline() 按行读取文件
            // 2. 当返回 null 时，表示文件读取完毕
            while ((line = bufferedReader.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭流，只需要关系 BufferedReader，因为底层会自动关闭 节点流
            try {
                bufferedReader.close();
                /*
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close(); // 底层会调用传入对象(节点流)关闭
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
                 */
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
