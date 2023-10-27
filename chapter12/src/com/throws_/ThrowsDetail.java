package com.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) {    // 调用了抛出异常的方法 method()，
        // 因此默认 public static void main(String[] args) throws ArithmeticException {...}
        method();
    }

    public static void method() {
        // 1. 对于编译异常，程序中必须 显式 处理，比如try-catch或者throws
        // 2. 对于运行时异常，程序中如果没有处理，默认就是throws的处理方式
        // 3. 子类重写父类方法时，对抛出异常的规定：子类重写的房啊，所抛出的异常类型要么和父类抛出的异常抑制，要么为父类抛出的类型的字类型
        // 4. 在throws过程中，如果有方法try-catch，就相当于处理异常，就可以不必throws
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;   // 默认 public static void method() throws ArithmeticException {...}
    }

    public static void f1() throws FileNotFoundException {
        // 1. 因为f3()方法抛出的是一个 *编译异常*
        // 2. 所以必须 显式 的处理这个编译异常
        // 3. 要么显式 throws，要么显式 try-catch-finally
        f2();   // 抛出异常
    }

    public static void f2() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("d://a.txt");
    }

    public static void f3() {
        // 1. 这里不显式 throws 或者 try-catch-finally 是OK的，因为默认处理
        // 2. 因为 f4() 抛出的是运行时异常，默认会 throws 处理
        // 3. 而Java中，并不要求程序显式处理 *运行时异常*
        f4();
    }

    public static void f4() throws ArithmeticException {

    }
}

class Father {
    public void method() throws RuntimeException {

    }
}

class Son extends Father {
    @Override
    public void method() throws NullPointerException {  // 子类重写父类的方法时，对抛出异常的规定
        // 子类重写的方法，抛出的异常要么和父类抛出的异常一致，要么为父类抛出异常的类型的字类型
    }
}