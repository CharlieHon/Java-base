package writer_;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) {
        /*
        1. BufferedReader 和 BufferedWriter 是按照字符操作的
        2. 不要去操作 二进制文件[声音，视频，doc，pdf]，可能造成文件损坏
         */
        String srcFilePath = "g:/story.txt";
        String destFilePath = "e:/a.txt";
        BufferedReader bfReader = null;
        BufferedWriter bfWriter = null;
        String line = null;
        try {
            bfReader = new BufferedReader(new FileReader(srcFilePath));
            bfWriter = new BufferedWriter(new FileWriter(destFilePath));

            // 说明：readLine() 读取一行内容，但是没有换行
            while ((line = bfReader.readLine()) != null) {
                bfWriter.write(line);
                bfWriter.newLine(); // 插入一个换行，换行符与系统相关
            }
            System.out.println("拷贝完毕！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bfReader != null) {
                    bfReader.close();
                }
                if (bfWriter != null) {
                    bfWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
