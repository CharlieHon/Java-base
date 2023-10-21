package com.hspedu.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
        // 抽象类不能被实例化
//        new Animal();
    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // 这里 eat 实现了，但是并没有什么意义
    // 即：父类方法不确定的问题
    // ---> 考虑将这个方法设计为抽象(abstract) 方法
    // ---> 抽象方法就是没有实现的方法，即没有方法体
    // ---> 当一个类中存在抽象方法时，需要将该类声明为 abstract 类
    // ---> 一般来说，抽象类会被继承，由子类实现
    public abstract void eat();
//    public void eat() {
//        System.out.println("这是一个动物，但是不知道吃什么...");
//    }
}

abstract class A {
    // 抽象类中可以没有抽象方法
    // 还可以有实现方法
    public void sayHi() {
        System.out.println("Hi~");
    }
}