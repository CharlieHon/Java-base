package com.hspedu.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.n1); // final 修饰 静态变量，调用时类不会被加载

        // 包装类，String 都是 final 类，不能被继承
        // public final class String {...}
    }
}

// final 和 static 往往搭配使用，效率更高，编译器做了优化处理
class BBB {
    public final static int n1 = 100;
    static {
        System.out.println("BB: 静态代码块...");
    };
}

final class AAA {
    // final类中的方法不需要再加 final 了，没必要
    public void say() {

    }
}
