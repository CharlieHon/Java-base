package com.wrapper_;

public class Integer01 {
    public static void main(String[] args) {
        // 演示 int <---> Integer 的装箱和拆箱
        // jdk5前是手动装箱和拆箱
        // 手动装箱 int->Integer
        int n1 = 100;
        Integer i = new Integer(n1);
        Integer i1 = Integer.valueOf(n1);
        // 手动拆箱 Integer->int
        int i2 = i.intValue();

        // jdk5及以后，可以自动装箱和自动拆箱
        int n2 = 200;
        // 自定装箱 int->Integer
        Integer integer2 = n2;  // 底层使用的是 Integer.valueOf(n2)
        // 自动拆箱 Integer->int
        int n3 = integer2;  // 底层仍然是 intValue() 方法
    }
}
