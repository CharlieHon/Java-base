package customgeneric;

import java.util.ArrayList;

public class CustomMethodGeneric {
    public static void main(String[] args) {
        // 泛型方法的使用
        Car car = new Car();
        car.fly("宝马", 100); // 在调用方法时，传入参数，编译器会自动确定类型。数值类型会进行装箱为引用类型
        car.fly(100, 100.1);    // Integer; Double
        // 测试
        Fish<String, ArrayList> a = new Fish<>();
        a.test("hello", 3.14f); // String; Float
    }
}

class Car { // 普通方法
    public void run() { // 普通方法

    }

    // 1. <T, R> 就是泛型
    // 2. 提供给 fly() 使用
    public<T, R> void fly(T t, R r) {
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class Fish<T, R> {  // 泛型类
    public void run() { // 普通方法

    }
    public<U, M> void eat(U u, M m) {   // 泛型方法

    }
    // 1. 下面 hi 方法不是泛型方法
    // 2. 使用了类声明的泛型
    public void hi(T t) {

    }
    // 泛型方法，可以使用类声明的泛型，也可以使用自己声明的泛型
    public<K> void test(T t, K k) {
        System.out.println(t.getClass());
        System.out.println(k.getClass());
    }
}