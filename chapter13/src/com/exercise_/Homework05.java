package com.exercise_;

public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b); // false
        System.out.println(a.equals(b));    // false 没重写 Object 的 equals() 方法
        System.out.println(a.name == b.name);   // true 都指向常量池中的 hspedu

        String s2 = new String("hspedu");   // new 在堆中 char[] value; s2 -> value -> "hspedu"
        String s3 = "hspedu";
        System.out.println(s1 == s2);   // false
        System.out.println(s2 == s3);   // false

        String t1 = "hello" + s1;   // 全是常量会优化；有变量则创建 StringBuilder sb; sb.append(s1); sb.append("hello");
        String t2 = "hellohspedu";
        System.out.println(t1.intern() == t2);  // true intern()始终返回指向常量池
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;   // 不是 new String()
    }
}