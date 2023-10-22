package com.hspedu.interface_;

import java.nio.file.attribute.FileAttribute;

public class ExtendsVSInterface {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "猴子会爬树...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 接口
interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

// 继承：当子类继承父类，就自动拥有了父类的功能
// 如果子类需要扩展功能，可以通过实现接口的方式扩展
// 实现接口是对Java单继承机制的补充
class LittleMonkey extends Monkey implements Fishable, Birdable {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "学游泳...");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "学飞翔...");
    }
}
