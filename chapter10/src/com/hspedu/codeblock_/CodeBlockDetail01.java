package com.hspedu.codeblock_;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        // 静态代码块执行 和 静态属性初始化 优先级相同，按照定义顺序执行
        A a = new A();  // 1. getN1()... 2. A 静态代码块~
        /*
        静态方法：getN1()...
        A 静态代码块~
        A 普通代码块~
        普通方法：getN2()...
        构造函数：A()...
         */

        System.out.println("=================");
        // 如果前面已经加载完类了(类只会加载一次)，则该处不会再加载类，也就不会再初始化静态属性、调用静态代码块；而是直接调用类方法：静态方法：sayHi()...
        A.sayHi();  // 通过类名调用静态方法时，没有创建对象；不会初始化普通属性，也不会调用普通代码块，也不会调用构造函数
        /* 如果前面没加载类，这里：先加载类 -> 静态变量初始化、调用静态代码块 -> 调用静态方法
        静态方法：getN1()...
        A 静态代码块~
        静态方法：sayHi()...
         */
    }
}

class A {
    // 静态属性的初始化
    public static int n1 = getN1();                 // (1)

    // 普通代码块
    {
        System.out.println("A 普通代码块~");         // (4)
    };

    // 普通方法初始化
    public int n2 = getN2();                        // (5)

    // 静态代码块
    static {
        System.out.println("A 静态代码块~");         // (3)
    }

    // 静态方法
    public static int getN1() {
        System.out.println("静态方法：getN1()...");  // (2)
        return 100;
    }

    // 静态方法，没被调用
    public static void sayHi() {
        System.out.println("静态方法：sayHi()...");
    }

    // 普通方法
    public int  getN2() {
        System.out.println("普通方法：getN2()...");  // (6)
        return 200;
    }

    // 构造函数
    public A() {
        System.out.println("构造函数：A()...");      // (7)
    }
}