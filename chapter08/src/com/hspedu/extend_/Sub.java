package com.hspedu.extend_;

public class Sub extends Base {
    public Sub() {
        // 子类构造器，默认第一句会隐式的调用父类的无参构造器
        // super();
        // 所以，当子类构造函数中第一句没有显式地调用父类的任意一个构造器时
        // 必须保证父类具有默认构造函数
        super();
        System.out.println("Sub()...");
    }

    public Sub(String name, int age) {
        // 不管子类使用哪个构造器，默认第一句都会调用父类无参构造器 super();
        super(name, age);   // 指定调用哪个父类构造器
        System.out.println("Sub(String name, int name)...");
    }

    public void sayOK() {
        System.out.println("Sub.sayOK()...");
        // 父类非 private 的属性和方法在子类可以访问
        System.out.println(n1 + " " + n2 + " " + n3);   // private: n4不可访问
        test100();
        test200();
        test300();
//        test400();  // 错误
        // 通过父类提供的方法来访问 private 属性
        System.out.println("n4 = " + getN4());
        callTest400();  // 通过父类的公共方法，调用父类的 private 方法
    }
}
