package com.exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        // 1. num1 / num2 => 10 / 0
        // 2. 当执行到 num1 / num2 是，因为nums = 0，程序就会出现(抛出)异常 ArithmeticException
        // 3. 当抛出异常后，程序就退出了，崩溃了，下面的代码就不会执行
        // 4. 这样的程序好吗？这样不好，不应该出现了一个不算致命的问题，就导致整个系统崩溃
        // 5. java设计者提供了一个叫 异常处理机制 来解决该问题
//        int res = num1 / num2;
        // 将该代码块选中，快捷键 ctrl+alt+t，选中try-catch
        // 6. 如果进行异常处理，那么即使出现了异常，程序也可以继续执行
        try {
            int res = num1 / num2;  // 运行时异常
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage()); // 输出异常信息

        }
        System.out.println("OK~");
    }
}
