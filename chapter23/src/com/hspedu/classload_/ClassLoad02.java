package com.hspedu.classload_;

/**
 * 说明一个类加载的链接阶段-准备
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}

class A {
    // 属性-成员变量-字段
    // 类加载的链接阶段-准备 属性如何处理
    // 1. n1 是实例属性，不是静态变量，因此在准备阶段，是不会分配内容
    // 2. n2 是静态变量，分配内存 n2 是默认初始化为 0，而不是20
    // 3. n3 是static final是常量，和静态变量不一样，因为一旦赋值就不变，n3 = 30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}