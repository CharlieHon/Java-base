package com.hspedu.codeblock_;

public class CodeBlockDetail03 {
    // 继承关系下，创建子类对象时，调用顺序
    public static void main(String[] args) {
        // 1. 进行类的加载，先加载父类，再加载子类
        // 2. 创建对象
        B1 b1 = new B1();
        /*
        // 加载父类 A1
A1：静态方法getN1()...
A1：静态代码块...
        // 加载子类 B1
B1：静态方法getB1()...
B1：静态代码块...
        // 构造父类对象
A1：普通方法getN2()...
A1：普通代码块...
A1：构造函数A1()...
        // 构造子类对象
B1：普通方法getB2()...
B1：普通代码块...
B1：构造函数B1()...
         */
    }
}

class A1 {
    public static int a1 = getN1();                     // (1)
    int a2 = getN2();                                   // (7)
    {
        // 普通方法块，可以使用任意成员(静态成员和非静态成员)
        System.out.println("A1：普通代码块...");          // (9)
    };
    static {
//        System.out.println(getN2());  // 错误：静态代码块只能直接调用静态成员
        System.out.println("A1：静态代码块...");          // (3)
    };


    public static int getN1() {
        System.out.println("A1：静态方法getN1()...");    // (2)
        return 10;
    }

    public int getN2() {
        System.out.println("A1：普通方法getN2()...");    // (8)
        return 20;
    }

    public A1() {
        System.out.println("A1：构造函数A1()...");       // (10)
    }
}

class B1 extends A1 {
    public static int b1 = getB1();                 // (4)
    private int b2 = getB2();                       // (11)

    {
        System.out.println("B1：普通代码块...");      // (13)
    }

    static {
        System.out.println("B1：静态代码块...");      // (6)
    }

    public static int getB1() {
        System.out.println("B1：静态方法getB1()...");    // (5)
        return 100;
    }
    public int getB2() {
        System.out.println("B1：普通方法getB2()...");    // (12)
        return 200;
    }

    public B1() {
        // 隐藏了
        // super();
        // 普通代码块和普通属性初始化
        System.out.println("B1：构造函数B1()...");   // (14)
    }
}