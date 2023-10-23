package com.hspedu.innerclass_;

import jdk.nashorn.internal.ir.CallNode;

/**
 * 演示 局部内部类
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02 {
    private int n1 = 100;
    public void m0() {
        System.out.println("Outer02: m0()...");
    }
    public void m1() {
        // 局部内部类是定义在外部类的局部位置，通常在方法内
        // 2. 不能添加访问修饰符，因为它的地位就是一个局部变量
        // 3. 作用域：仅仅在定义它的方法或代码块中
        final class Inner02 { // 局部内部类(本质仍然是一个类)
            // 1. 可以直接访问外部类的所有成员，包含私有的
            // 7， 外部类和内部类的成员重名，访问时默认遵循就近原则
            // 要想访问外部类，可以通过 外部类.this.成员 访问
            private int n1 = 800;
            public void f1() {
                // 4. 局部内部类可以直接访问外部类的成员
                System.out.println("n1=" + n1); // 800
                // 7. 访问外部类的重名属性，外部类.this.属性
                // Outer02.this 本质就是外部类的对象，即哪个对象调用了 m1(
                System.out.println("Outer02.this.n1=" + Outer02.this.n1);   // 100
                m0();
            }
        }

        // 5. 外部类在方法中，可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }

    {   // 代码块
        class Inner03 {

        }
    }
}