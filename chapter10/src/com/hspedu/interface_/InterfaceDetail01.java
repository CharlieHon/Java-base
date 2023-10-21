package com.hspedu.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {

    }
}

interface IB {
    void hi();

    // 接口中的属性只能是 final，
}
interface IC {
    void say();
}

// 一个类可以同时实现多个接口
class Pig implements IB, IC {
    @Override
    public void hi() {
        System.out.println("Hi~");
    }

    @Override
    public void say() {
        System.out.println("Hello...");
    }
}
