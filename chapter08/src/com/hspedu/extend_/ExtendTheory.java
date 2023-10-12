package com.hspedu.extend_;

public class ExtendTheory {
    public static void main(String[] args) {
        Son son = new Son();    // 内存的布局
        // ?-> 按照查找关系来返回信息
        // (1) 首先看子类是否有这个属性
        // (2) 如果子类有这个属性，并且可以访问，则返回信息
        // (3) 如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息...)
        // (4) 如果父类没有就按照(3)的规则，继续找上级父类，直到Object
        // 当查找到属性存在某个父类中时，如果没有访问权限就会报错，而不是继续向上级父类继续查找！
        System.out.println(son.name);   // 大头儿子；Son类中name是默认访问权限，在同一个包下可以访问
        System.out.println(son.age);    // 39
        System.out.println(son.hobby);  // 旅游
    }
}

class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
}
class Father extends GrandPa {
    String name = "大头爸爸";
    int age = 39;
}
class Son extends Father {
    String name = "大头儿子";
}