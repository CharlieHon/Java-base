package exercise;

import java.io.*;

public class Homework02 {
    // 使用BufferedReader读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上
    public static void main(String[] args) throws IOException {
        String fileName = "e:/a.txt";
        // InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName), "gbk");
        // BufferedReader br = new BufferedReader(inputStreamReader);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintStream out = System.out;
        String line = null;
        int lineNum = 0;
        while ((line = br.readLine()) != null) {
            lineNum++;
            out.println(lineNum + " " + line);
        }
        br.close();
    }
}
