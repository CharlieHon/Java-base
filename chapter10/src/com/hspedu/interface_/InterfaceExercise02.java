package com.hspedu.interface_;

public class InterfaceExercise02 {
    public static void main(String[] args) {

    }
}

interface PA {
    int x = 10; // public static final int x = 10;
}

class PB {
    int x = 1;  // 普通属性
}

class PC extends PB implements PA {
    public void f1() {
//        System.out.println(x);  // 错误：不明确x，父类属性和接口属性冲突
//        System.out.println(this.x);  // 错误：同上
        // 可以明确地指定x
        System.out.println(PA.x);   // 10   访问接口属性，就用接口名.属性
        System.out.println(super.x);    // 1    访问父类属性，就用super.属性
    }
    public static void main(String[] args) {
        new PC().f1();
    }
}
