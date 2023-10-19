package com.hspedu.codeblock_;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        BBB b = new BBB();
        /*
        普通代码块：AAA...    // 调用父类构造器，执行父类普通代码块
        AAA()...    // 执行父类构造函数
        普通代码块：BBB...    // 执行本类普通代码块
        BBB()...    // 执行本类构造函数
         */
    }
}

class AAA {

    {
        System.out.println("普通代码块：AAA...");
    }

    public AAA() {
        // 因为 AAA 父类为 Object，所以直接是执行的本类的普通代码块
        // (1) super(); // 父类为 Object 直接返回
        // (2) 调用本类的普通代码块   // AAA类 没有普通代码块
        System.out.println("AAA()...");
    }
}

class BBB extends AAA {

    {
        System.out.println("普通代码块：BBB...");
    }

    public BBB() {
        // 隐藏的细节
        // (1) super(); // 调用父类 AAA 构造函数
        // (2) 调用本类的普通代码块
        System.out.println("BBB()...");
    }
}