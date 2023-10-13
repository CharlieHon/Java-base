package com.hspedu.poly_;

public class Cat extends Animal {
    String name;

    public Cat(String name) {
        super(name);    // 调用父类构造器，则super.name = name;
        // 因为继承了父类的 getName 方法，所以 Cat 对象在调用 getName 方法时
        // 会调用父类方法，返回父类 name
    }
}
