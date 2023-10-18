package com.hspedu.static_;

public class ChildGame {
    public static void main(String[] args) {

        // 类变量随着类的加载而创建，所以即使没有创建对象时，也可以访问
        System.out.println(Child.count);    // 0

        Child c1 = new Child("李自成");
        c1.join();

        // 通过对象名.类变量名
        // 类变量的访问，必须遵守相关的访问权限
        System.out.println(c1.count);   // 1

        // 非静态变量不能通过：类名.变量名 访问
//        System.out.println(Child.cnt);    // 错误

        Child c2 = new Child("李慕白");
        Child c3 = new Child("俞秀莲");
        // 类变量，可以通过类名访问
        System.out.println("共有 " + Child.count + " 个小孩加入游戏...");

    }
}

class Child {
    private String name;
    // 定义一个变量 count，是一个类变量(静态变量) static 变量
    // (1)该变量最大的特点就是会被 Child 类所有的对象实例共享
    // (2)static变量在类加载时就生成
    public static int count = 0;
    public int cnt = 0;

    public Child(String name) {
        this.name = name;
    }
    public void join() {
        ++count;
        System.out.println(name + " 加入了游戏...");
    }
}