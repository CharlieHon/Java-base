package transformation;

import java.io.*;

public class OutputStreamWriter_ {
    // 把FileOutputStream字节流，转成字符流OutputStreamWriter
    // 指定处理的编码 utf-8/gbk
    public static void main(String[] args) throws IOException {
        String filePath = "e:/hsp.txt";
        String charSet = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath, true), charSet);
        osw.write("haha");
        osw.close();
        System.out.println("保存成功，编码方式" + charSet);
    }
}
