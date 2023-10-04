package chapter03;

public class Operator {
    public static void main(String[] args) {
        // 程序中 + 号的使用
        // 1.当左右两边都是数值型时，则做加法运算
        // 2.当左右两边有一方为字符串，则做拼接运算
        // 3.运算的顺序，从左到右
        System.out.println(100 + 98);   // 198
        System.out.println("100" + 98); // 10098
        System.out.println(100 +3 + "hello");   // 103hello
        System.out.println("hello" + 100 + 3);  // hello1003
    }
}
