package com.hspedu.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        // 接口中的属性，是 public static final
        System.out.println(IB.n1);  /// 说明 n1 是 static
//        IB.n1 = 6;    // 错误：final
    }
}

interface IB {
    int n1 = 10;    // 等价于 public static final int n1 = 10;
    void hi();

    // 接口中的属性只能是 final，
}
interface IC {
    void say();
}

// 接口不能继承其它类，但是可以继承多个别的接口
// 接口的修饰符只能是 public 和 默认
interface ID extends IB, IC {

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
