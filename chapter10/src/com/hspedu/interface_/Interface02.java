package com.hspedu.interface_;

public class Interface02 {
    public static void main(String[] args) {
        A a = new A();
        a.hi(); // 抽象方法 Hi~
        a.ok(); // 默认方法 ok...
    }
}

// 1. 如果一个类 implements 实现接口
// 2. 需要将该接口的所有抽象方法都实现
class A implements AInterface {
    @Override
    public void hi() {
        System.out.println("Hi~");
    }
}

class B implements IA { // 一个普通类实现接口，就必须将该接口的所有抽象方法实现
    @Override
    public void hi() {
        System.out.println("实现hi()...");
    }
    @Override
    public void say() {
        System.out.println("实现say()...");
    }
}

// 4. 抽象类实现接口，可以不实现接口的抽象方法
abstract class C implements IA { }

// 1. 接口不能被实例化
interface IA {
    // 2. 接口中的所有方法都是 public，即默认public，接口中的抽象方法，可以不同 abstract 修饰
    public void say();  // 接口中方法默认是 public，所以可以不用写 public
    // 3. 一个普通类实现接口，就必须将该接口的所有抽象方法都实现
    void hi();
}