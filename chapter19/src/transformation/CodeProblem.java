package transformation;

import java.io.*;

public class CodeProblem {
    public static void main(String[] args) throws IOException {
        // 读取 e:/a.txt
        // 1. 创建字符输入流 BufferedReader
        // 2. 使用 BufferedReader 对象读取文件
        // 3. 在默认情况下，读取文件是按照 UTF-8 编码方式
        String filePath = "e:/a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读取的内容=" + s);
        br.close();
    }
}
