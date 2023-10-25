package com.hspedu.innerclass_;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {
        // 创建一个基于类的匿名内部类
        Person p = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi()..." + n1);    // 可以访问外部类的所有成员
            }
        };
        p.hi(); // 动态绑定，运行类型 Outer05$1
        System.out.println("p.getClass(): " + p.getClass());

        // 也可以直接调用，因为匿名内部类本事也是返回对象
        new Person() {
            private int n1 = 21;
            @Override
            public void hi() {
                // 访问内部匿名类的属性，因为重名遵循就近原则
                System.out.println("匿名内部类又重写了 hi()..." + n1);   // 21
            }

            @Override
            public void ok(String str) {
                super.ok(str);
                // 访问外部类同名成员
                // Outer05.this 是指调用 f1()的对象
                System.out.println("Outer05: n1=" + Outer05.this.n1);   // 99
            }
        }.ok("Bruce");
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }

    public void ok(String str) {
        System.out.println("Person ok() " + str);
    }
}

