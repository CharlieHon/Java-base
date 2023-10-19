package com.hspedu.final_;

public class Final01 {
    public static void main(String[] args) {
        // 当不希望某个局部变量被修改，可以使用 final 修饰
        final double NUM = 0.6;
//        NUM = 0.7;  // 错误：不能修改 final 变量
    }
}

// 如果要求A类不能被其他类继承
// 可以使用 final 修饰 A类
final class A {}

//class B extends A {}

class C {
    // 如果要求 hi() 方法不能被子类重写，可以使用 final 修饰
    public final void hi() {
        System.out.println("C: hi()...");
    }
}

class D extends C {
//    public void hi() {
//        // 这里重写了父类的 hi() 方法
//        System.out.println("D: hi()...");
//    }
}

class E {
    // 修饰类型属性，则不能修改
    public final double TAX_RATE = 0.08;
}