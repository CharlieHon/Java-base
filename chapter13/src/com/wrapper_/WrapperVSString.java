package com.wrapper_;

public class WrapperVSString {
    public static void main(String[] args) {
        // 包装类(Integer)->String
        Integer i1 = 100;    // 自动装箱
        // 方式1
        String str1 = i1 + "";
        // 方式2
        String str2 = i1.toString();
        // 方式3
        String str3 = String.valueOf(i1);

        // String -> 包装类(Integer)
        String str4 = "1895";
        Integer i2 = Integer.parseInt(str4);    // 返回int类型，自动装箱为Integer
        Integer i3 = new Integer(str4); // 直接构造器接收 String 参数

        System.out.println("OK~");
    }
}
