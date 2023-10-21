package com.hspedu.abstract_;

public class Test {
    public static void main(String[] args) {
        // 饿汉模式
        System.out.println(AA.n2);  // AA被构造...     1000
        AA a1 = AA.getInstance();
        AA a2 = AA.getInstance();
        System.out.println(a1 == a2);   // true

        // 懒汉模式
        System.out.println(BB.n2);  // 62
        BB b1 = BB.getInstance();   // BB被构造...
        BB b2 = BB.getInstance();
        System.out.println(b1 == b2);   // true
    }
}

// 单例模式
class AA {
    private int n1;
    public static int n2 = 1000;
    private static AA a = new AA(10);   // 饿汉模式

    private AA(int n1) {
        System.out.println("AA被构造...");
        this.n1 = n1;
    }

    public static AA getInstance() {    // 通过静态方法返回 单例
        return a;
    }
}

class BB {
    private int n1;
    public static int n2 = 62;
    private static BB b = null;

    private BB(int n1) {
        System.out.println("BB被构造...");
        this.n1 = n1;
    }

    public static BB getInstance() {
        if (b == null) {
            b = new BB(73);
        }
        return b;
    }
}