package com.charlie.threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.start();    // 这里不能调用 start()

        // 创建Thread匿名对象，把dog对象(实现Runnable)，放入Thread
        new Thread(dog).start();

//        Tiger tiger = new Tiger();
//        new ThreadProxy(tiger).start();
    }
}

class Animal {}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("吊睛白额的大虫~");
    }
}

// 线程代理类，模拟一个简单的 Thread类
class ThreadProxy implements Runnable { // 可以把 ThreadProxy类 当作 Thread类

    // 属性，类型是 Runnable
    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();   // 动态绑定，运行类型 Tiger
        }
    }

    public void start() {
        // 这个方法是真正实现多线程的方法
        start0();
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程(" + Thread.currentThread().getName() + "): hi~" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}
