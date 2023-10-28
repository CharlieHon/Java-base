package com.string_;

public class String02 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";   // a, b都是指向常量池中同一个地址
        System.out.println(a.equals(b));    // true
        System.out.println(a == b);         // true


        String a1 = "hsp";  // a指向 常量池 中的 "hap"
        String b1 = new String("hsp");  // b指向 堆 中的对象，堆中的对象指向常量池
        System.out.println(a1.equals(b1));  // true 内容相同
        System.out.println(a1 == b1);   // false
        /*
        如果常量池中有b1内容，则b1.intern()返回常量池中的地址，否则添加到常量池然后返回
         */
        System.out.println(a1 == b1.intern()); // true
        System.out.println(b1 == b1.intern());  // false b对象指向堆，b.intern()指向常量池
    }
}
