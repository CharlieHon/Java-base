package com.string_;

public class StringExercise04 {
    public static void main(String[] args) {
        String s1 = "hspedu";   // s1指向池中"hspedu"
        String s2 = "java";     // s2指向池中"java"
        String s3 = "hspedujava";   // s3指向池中"hspedujava"
        String s4 = (s1 + s2).intern(); // s4指向池中"hspedujava"   intern() 返回与字符串内容相同的常量池地址/对象
        System.out.println(s3 == s4);   // true
        System.out.println(s3.equals(s4));  // true 内容相同
    }
}
