package com.hspedu.abstract_;

public class AbstractDetail01 {
    public static void main(String[] args) {

    }
}

// 抽象类的本质还是类，所以可以有类的各种成员
abstract class B {
    public static int n1 = 10;
    private String name = "Charlie";
    public String getName() {
        return name;
    }
    public abstract void eat(); // 抽象方法
}

// 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法
class C extends B { // 要么声明为抽象类，要么实现父类的所有抽象方法
    @Override
    public void eat() { // C子类实现了父类B的抽象方法
        System.out.println("吃同发号~");
    }
}

abstract class D extends B {    // 声明为抽象类
}