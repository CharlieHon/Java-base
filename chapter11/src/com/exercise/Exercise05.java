package com.exercise;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Exercise05 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();      // 骑马赶路...
        System.out.println("====");
        tang.passRiver();   // 坐船渡河...
        tang.passRiver();   // 坐船渡河...
    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("骑马赶路...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("坐船渡河...");
    }
}

class Factory {
    // 马儿始终是同一匹，白龙马
    private static final Horse horse = new Horse(); // 饿汉式
    private Factory() {};   // 构造器私有化
    // 将方法设置为 static
    public static Horse getHorse() {
//        return new Horse();
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    // 在创建人对象时，事先分配一个交通工具
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    // 要求一般情况下用Horse作为交通工具，遇到大和时用Boat作为交通工具
    // 这里涉及一个编程思路，就是可以把具体的要求，封装成方法 -> 这里就是编程思想
    // ？如何不浪费在创建对象时，传入的交通工具对象
    public void passRiver() {       // 防止始终使用的是传入的马
        // 等价于 if (this.vehicles == null || this.vehicles instanceof Horse)
        // 判断是否为空，如果不为空运行类型是否是 Boat
        if (!(this.vehicles instanceof Boat)) {
            this.vehicles = Factory.getBoat();
        }
        this.vehicles.work();
    }
    public void common() {
        // 判断一下，当前的 vehicles 属性是否存在
        if (!(this.vehicles instanceof Horse)) {
            // 这里使用的是多态
            this.vehicles = Factory.getHorse();
        }
        // 这里体现使用接口调用
        this.vehicles.work();
    }
}