package com.hspedu.super_;

public class B extends A {

    public int n1 = 666;

    public void hi() {  // 访问父类的属性，但不能访问父类的 private 属性
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    public void ok() {  // 访问父类方法，同属性
        super.m1();
        super.m2();
        super.m3();
    }
    public B() {
//        super();
//        super("jack", 21);
//        super("bruce");
    }

    public void cal() {
        System.out.println("B.cal()...");
    }

    public void sum() {
        System.out.println("B.sum()...");
        // 希望调用父类A的 cal 方法
        // 因为子类B类没有 cal 方法，因此可以使用下面三种方式
        // 找 cal 方法时，顺序是：
        // (1) 先找本类，如果有并且可以调用，则调用；
        // (2) 如果没有，则找父类(如果有，并可以调用，则调用)
        // (3) 如果父类没有，则继续找父类的父类，整个规则是一样的，直到 Object 类
        // 提示： 当某类中有该方法但是无调用权限时，会报错 cannot access，并不继续向上查找。
        //          没有找到，也提示方法不存在 cannot resolve
//        cal();  // B.cal()...
//        this.cal(); // 与 cal() 等价，也会进行查找，并非尽在 当前对象方法中查找
        super.cal();    // A.cal()... 与上不同，是直接查找父类，其他规则一样

        // 属性的查找方式同 方法
        System.out.println("n1=" + n1); // 666
        System.out.println("n1=" + this.n1);    // 同上
        System.out.println("n1=" + super.n1);   // 100
    }
}
