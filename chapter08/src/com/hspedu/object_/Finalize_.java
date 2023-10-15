package com.hspedu.object_;

public class Finalize_ {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");   // bmw -> Car
        // 这时 car对象就是一个垃圾，垃圾回收期就会回收(销毁)对象
        // 在销毁对象前，会调用该对象的 finalize 方法
        // 可以在 finalize 方法中，写自己的业务逻辑代码(比如释放资源：数据库连接，或者打开文件...)
        // 如果不重写 finalize 方法，那么就会调用 Object类的 finalize，即默认处理
        // 如果重写，即实现自己的逻辑
        bmw = null; // 并非每有一个垃圾产生就会回收，有算法调控
        // 主动调用 System,gc() 运行垃圾回收器
        System.gc();    // 销毁 Car: BMW
        System.out.println("OK~");
    }
}
class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override   // 重写 finalize
    protected void finalize() throws Throwable {
        System.out.println("销毁 Car: " + this.name);
    }
}