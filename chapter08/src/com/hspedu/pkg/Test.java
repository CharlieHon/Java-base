package com.hspedu.pkg;

import com.hspedu.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        // 在不同包下，可以访问public修饰的属性或方法
        // 但是不能访问 protected, 默认 和 private
        System.out.println(a.n1);
        a.m1(); // 在不同包，仅能访问 public 修饰的属性
        // 不能访问 a.m2(); a.m3(); a.m4();
    }
}
