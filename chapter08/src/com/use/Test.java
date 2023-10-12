package com.use;

import com.xiaoming.Dog;

public class Test {
    public static void main(String[] args) {
        /* 包的命名
         * 1. 只能包含数字、字母、下划线、小圆点，但不能用数字开头，不能是关键字或保留字
         * 2. 一般是小写字母+小圆点，如com.公司名.项目名.业务模块名
         * 一个包下包含很多不同的类，java中常用的包有：
         * - java.lang.*    // lang包是基本包，默认引入，不需要再引入
         * - java.util.*    // util包，系统提供的工具包，使用Scanner
         * - java.net.*     // 网络包，网络开发
         * - java.awt.*     // 是做java的界面开发，GUI
         * 注意事项和使用细节
         * 1. package的作用是声明当前类所在的包，需要放在class的最上面，一个类中最多只有一句package
         * 2. import指令 位置放在package的下面，在类定义前面，可以有多句且没有顺序要求
         */
        Dog dog = new Dog();    // 仅能访问 public 的属性 name
        System.out.println(dog);

        com.xiaoqiang.Dog dog1 = new com.xiaoqiang.Dog();
        System.out.println(dog1);

    }
}
