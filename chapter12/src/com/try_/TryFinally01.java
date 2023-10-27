package com.try_;

public class TryFinally01 {
    public static void main(String[] args) {
        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally {
            System.out.println("执行了finally...");
        }
        System.out.println("程序继续执行...");    // 不会执行，因为在执行完finally代码块后，程序即崩溃
    }
}
