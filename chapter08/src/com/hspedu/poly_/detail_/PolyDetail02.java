package com.hspedu.poly_.detail_;

public class PolyDetail02 {
    public static void main(String[] args) {
        // 属性没有继承之说！属性的值看编译类型
        Base base = new Sub();
        System.out.println("base.count=" + base.count); // base.count=10
        Sub sub = new Sub();
        System.out.println("sub.count=" + sub.count);   // sub.count=20
    }
}
class Base {
    int count = 10;
}

class Sub extends Base {
    int count = 20;
}