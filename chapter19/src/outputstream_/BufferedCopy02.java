package outputstream_;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) {    // 演示使用BufferedOutputStream完成二进制文件拷贝
        String srcFilePath = "e:/cpp.png";
        String destFilePath = "g:/a.png";
        BufferedOutputStream bfOS = null;
        BufferedInputStream bfIS = null;
        try {
            bfIS = new BufferedInputStream(new FileInputStream(srcFilePath));
            bfOS = new BufferedOutputStream(new FileOutputStream(destFilePath));
            // 循环读取文件，并写入到 destFilePath
            int dataLen = 0;
            byte[] buf = new byte[1024];
            while ((dataLen = bfIS.read(buf)) != -1) {  // 当返回-1时，表示文件读取完毕
                bfOS.write(buf, 0, dataLen);
            }
            System.out.println("拷贝完毕！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bfIS != null) {
                    bfIS.close();
                }
                if (bfOS != null) {
                    bfOS.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
