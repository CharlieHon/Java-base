package com.charlie.threaduse;

/**
 * 演示通过继承Thread类，创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        // 创建Cat对象，可以当作线程使用
        Cat cat = new Cat();

        /*
        (1)
        public synchronized void start() {
            start0();
        }
        (2)
        // start0() 是本地房啊，是JVM调用，底层是c/c++实现
        // 真正实现多线程的效果是 start0() 而不是 run()
        private native void start0();
         */
        cat.start();    // 启动线程 -> 最终会执行 run() 方法

        // run方法就是一个普通的房啊，并没有真正启动一个线程，程序会阻塞在此，
        // 直到把run方法执行完毕，才会向下执行
//        cat.run();

        // 当 main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        // 这时，主线程和子线程交替执行
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程(" + Thread.currentThread().getName() + ")，i=" + i);
            Thread.sleep(1000);
        }
    }
}

// 1. 当一个类继承了 Thread类，该类就可以当作一个线程使用
// 2. 重写 run() 方法，写上自己的业务逻辑
// 3. run Thread类实现了 Runnable接口的 run方法
/*  Thread类中的 run() 方法
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
 */
class Cat extends Thread {

    private int count = 0;

    @Override
    public void run() { // 重写 run() ，实现自己的业务逻辑
        while (true) {
            // 该线程每隔1秒，在控制台输出一段信息
            System.out.println("同学们，大家起来，担负起天下的兴亡" + (++count)
                            + " 线程名：" + Thread.currentThread().getName());
            // 让线程休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 80) {
                // 当 count 到8，退出 while，该线程也就退出
                break;
            }
        }
    }
}
