package chapter07;

public class MethodDetail02 {
    public static void main(String[] args) {
        /** 注意事项
         * 1. 同一个类中的方法调用：直接调用即可。
         * 2. 跨类中的方法A类调用B类方法：需要通过对象名调用。
         * 3. 特别说明：跨类的方法调用和方法的访问修饰符相关
         */
        A a = new A();
        a.sayOk();
        a.m1();
    }
}

class A {
    // 同一个类中的方法调用：直接调用即可
    public void print(int n) {
        System.out.println("print()方法被调用 n = " + n);
    }

    public void sayOk() {   // sayOk调用 print
        print(10);
        System.out.println("继续执行sayOk()");
    }

    // 跨类中的方法，A类调用B类方法：需要通过对象名调用
    public void m1() {
        // 创建B对象
        System.out.println("A类m1()被调用");
        B b = new B();
        b.hi();
    }
}

class B {
    public void hi() {
        System.out.println("B类中的 hi()被执行");
    }
}
