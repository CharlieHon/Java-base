package com.hspedu.main_;

public class Main01 {
    public static void main(String[] args) {
        // String[] args 是运行时传入的参数
        // 形式：java 运行的程序 参数1 参数2 参数3
        for (int i = 0; i < args.length; i++) {
            System.out.println("第 " + (i + 1) + "个参数是：" + args[i]);
        }
    }
}
