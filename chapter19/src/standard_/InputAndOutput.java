package standard_;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        // System类的 public final static InputStream in = null;
        // 运行类型：BufferedInputStream
        // 表示标准输入 键盘
        System.out.println(System.in.getClass());   // class java.io.BufferedInputStream
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        String s = scanner.next();
        System.out.println("s=" + s);

        // public final static PrintStream out = null;
        // 运行类型：PrintStream
        // 表示标准输出 显示器
        System.out.println(System.out.getClass());  // class java.io.PrintStream
    }
}
