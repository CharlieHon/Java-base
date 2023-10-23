package com.hspedu.innerclass_;
/**
 * 演示 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
        outer04.method2();
    }
}

class Outer04 { // 外部类
    private int n1 = 10;    // 属性
    public void method() {  // 方法
        // 基于接口的匿名内部类
        // 1 需求：想使用接口A，并创建对象
        // 2 传统方式：写一个类，实现该接口，并创建对象
        // 3 需求：Tiger类只使用一次，后面不再使用
        // 4 可以使用外部类来简化开发
        // 5, tiger的编译类型 ： A
        // 6. tiger的运行类型 ： 就是匿名内部类：Outer04$1
        /*
        底层实现，系统分配
        class Outer04$1 implements A {
             @Override
            public void cry() {
                System.out.println("老虎：虎啸...");
            }
        }
         */
        // 7. jdk底层在创建匿名内部类 Outer04$1 后，立即创建了 Outer04$1实例，并且
        // 把地址返回给 tiger
        // 8. 匿名内部类使用一次，就不能再使用。对象tiger是可以继续使用的
        A tiger = new A() {
            @Override
            public void cry() {
                System.out.println("老虎：虎啸...");
            }
        };
        System.out.println("tiger=" + tiger.getClass());
        tiger.cry();
//        A a = new Tiger();
//        a.cry();
    }

    public void method2() {
        // 演示基于类的匿名内部类
        // 1. father1 编译类型 Father
        // 2. father1 运行类型 Outer04$2
        // 3. 底层会创建匿名内部类
        /*
        class Outer04$2 extends Father {

        }
         */
        // 4. 同时也返回了 匿名内部类的实例对象
        // 5. 参数 "Jack" 传递给了 Father类的构造器
        Father father1 = new Father("Jack") {
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test()...");
            }
        };
        System.out.println("father1对象的运行类型：" + father1.getClass()); // Outer04$2
        father1.test();
        // 创建 Father类实例
        Father father2 = new Father("John");
    }
}

interface A {   // 接口
    public void cry();
}

//class Tiger implements A {
//    @Override
//    public void cry() {
//        System.out.println("老虎：虎啸...");
//    }
//}
//
//class Dog implements A {
//    @Override
//    public void cry() {
//        System.out.println("小狗：汪汪汪...");
//    }
//}

class Father {  // 类
    public Father(String name) {    // 构造器
        System.out.println("接收到了" + name);
    }
    public void test() {    // 方法

    }
}
