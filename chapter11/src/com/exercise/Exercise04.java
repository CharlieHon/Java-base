package com.exercise;

public class Exercise04 {
    public static void main(String[] args) {
        new A().testB();
    }
}

class A {   // 外部类
    private String name = "李华";
    public void testB() {
        class B {   // 局部内部类
            private String name = "张三";
            public void show() {
                System.out.println("B: name=" + name);
                System.out.println("A: name=" + A.this.name);   // 访问外部类同名属性
            }
        }
        B b = new B();
        b.show();
    }
}