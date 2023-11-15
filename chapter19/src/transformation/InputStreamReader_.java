package transformation;

import java.io.*;

public class InputStreamReader_ {
    // 转换流解决中文乱码问题
    // 将字节流 FileInputStream 转成字符流 InputStreamReader，指定编码 gbk.utf-8
    public static void main(String[] args) throws IOException {
        String filePath = "e:/a.txt";
        // 1. 把 FileInputStream -> InputStreamReader
        // 2. 指定编码 gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        // 3. 把 InputStreamReader -> BufferedReader
        BufferedReader br = new BufferedReader(isr);    // 可以将2和3合在一起
        // 4. 读取
        String s = br.readLine();
        System.out.println("读取的内容=" + s);
        // 5. 关闭外层流
        br.close();
    }
}
