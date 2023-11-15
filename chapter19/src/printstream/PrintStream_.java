package printstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    // 演示PrintStream(字节打印流)
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        // 默认情况下，PrintStream的输出数据位置是标准输出，即显示器
        /* print底层使用的是write，所以可以直接调用write进行打印/输出
        public void print(String s) {
            if (s == null) {
                s = "null";
            }
            write(s);
        }
         */
        out.print("Hello, world!\n");
        out.write("你好".getBytes());
        out.close();

        // 可以修改打印流输出的位置/设备
        // 输出修改到 "e:/a.txt"
        /*
        public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);   // native方法
        }
         */
        System.setOut(new PrintStream("e:/a.txt"));
        System.out.println("haha~");
    }
}
