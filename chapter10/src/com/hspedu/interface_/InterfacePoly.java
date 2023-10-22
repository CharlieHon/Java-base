package com.hspedu.interface_;

public class InterfacePoly {
    public static void main(String[] args) {
        // 接口多态
        // 1. 接口类型的变量 if1 可以指向事项了IF接口的对象实例
        IF if1 = new Monster();
        if1 = new Car();

        // 2. 接口多态数组
        IF[] ifs = new IF[2];
        ifs[0] = new Monster();
        ifs[1] = new Car();
        for (int i = 0; i < ifs.length; i++) {
            ifs[i].test();  // 多态绑定
            if (ifs[i] instanceof Monster) {    // 判断运行类型
                ((Monster) ifs[i]).f();
            } else {
                ((Car) ifs[i]).f1();
            }
        }

    }
}

interface IF {
    void test();
}
class Monster implements IF {

    public void f() {
        System.out.println("杰顿光波...");
    }

    @Override
    public void test() {
        System.out.println("怪兽练习散打...");
    }
}
class Car implements IF {
    public void f1() {
        System.out.println("斯特里姆光线...");
    }
    @Override
    public void test() {
        System.out.println("Car练习八齿光轮");
    }
}
