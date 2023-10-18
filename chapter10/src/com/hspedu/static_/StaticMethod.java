package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu stu = new Stu("小明");
        stu.payFee(100);
        Stu stu1 = new Stu("小昭");
        stu1.payFee(200);
        // 输出当前收到的总学费
        Stu.showFee();

        // 如果希望不创建实例，也可以调用某个方法(即当作工具来使用)
        // 这时，把方法做成静态方法时非常合适
        System.out.println("9的算术平方根=" + Math.sqrt(9));
        System.out.println(MyTools.sum(32, 66));

        // 非静态方法/普通方法，不能通过类名调用
//        Stu.sayHi();    // 错误，需要先创建对象，再调用

    }
}

// 开发自己的工具类，可以将方法做成静态的，方便调用
class MyTools {
    public static double sum(double n1, double n2) {
        return n1 + n2;
    }
}

class Stu {
    private String name;
    // 定义一个静态变量，来累计学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    // 1. 当方法使用 static 修饰后，该方法就是静态方法
    // 2. 静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("总学费：" + Stu.fee);
    }

    // 静态方法只能访问静态成员和静态方法
    public static void sayHello() {
        // 类方法中不允许使用和对象有关的关键字
        // 比如 this 和 super。普通方法可以
//        System.out.println(this.name + " 向你打招呼~");    // 错误
        showFee();
//        sayHi();    // 错误：不能访问非静态方法
    }

    // 非静态方法
    public void sayHi() {
        System.out.println(name + " 向你打了声招呼~");
        sayHello(); // 非静态方法可以访问静态方法
        System.out.println(fee);    // 也可以访问静态属性
    }
}