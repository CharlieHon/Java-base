package com.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hello"; // 创建 a 对象
        String b = "abc";   // 创建 b 对象
        // 1. 先创建一个 StringBuilder sb = new StringBuilder();
        // 2. 执行 sb.append("hello");
        // 3.       sb.append("abc");
        // 4. String c = sb.toString(); // new 了一个新对象
        // 最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
        String c = a + b;
        String d = "helloabc";  // d 直接指向常量池中的 "helloabc"
        System.out.println(c == d); // false
        String e = "hello" + "abc";
        System.out.println(d == e); // true
    }
}
