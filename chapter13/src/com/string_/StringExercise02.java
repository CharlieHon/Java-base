package com.string_;

public class StringExercise02 {
    public static void main(String[] args) {
        // 1. String是一个final类，代表不可变的字符序列
        // 2. 字符串是不可变的，一个字符串对象一旦被分配，其内容是不可变的
        String s1 = "hello";    // 常量池创建一个对象 "hello" s1指向 "hello"
        s1 = "haha";    // 常量池创建另一个对象 "haha" s2指向 "haha"

        String a = "hello" + "world";   // 编译器优化，等价于 String a = "helloworld"; 仅创建了一个对象
    }
}
