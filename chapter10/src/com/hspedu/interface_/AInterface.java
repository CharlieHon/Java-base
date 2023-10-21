package com.hspedu.interface_;

public interface AInterface {
    // 写属性
    public int n1 = 10;
    // 写方法
    // 在接口中，抽象方法，可以省略 abstract 关键字
    public void hi();   // 抽象方法

    // 在jdk8后，可以有m默认实现方法，需要使用 default 关键字修饰
    default public void ok() {
        System.out.println("ok...");
    }
    // 在 jdk8 后，可以有静态方法
    public static void f() {
        System.out.println("f()...");
    }
}
