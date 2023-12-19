package com.charlie.sync;

/**
 * 使用多线程，模拟三个窗口同时售票 100 张
 */
public class SellTicket {
    public static void main(String[] args) {
        // 测试 synchronized
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}

// 实现接口方式，使用 synchronized 实现线程同步
class SellTicket03 implements Runnable {

    private static int ticketNum = 100;   // 让多个线程共享 ticketNum
    private boolean loop = true;
    Object obj =  new Object();

    // 同步方法(静态的)的锁为当前类本身
    /*
    1. public synchronized static void m1() {} 锁是加载 SellTicket03.class 上
    2. 如果在静态方法中，实现一个同步代码块
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {}

    public static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    /*
    1. public synchronized void sell()  就是一个同步方法
    2. 这时锁在 this 对象
    3. 也可以在代码块上写 synchronized，同步代码块，互斥锁可以this对象，或者其它同一个对象
     */
    public synchronized void sell() {   // 同步方法，在同一个时刻，最多只能有一个线程来执行 run() 方法
        synchronized (/*this*/ obj) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
        }

        // 休眠50ms
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("线程(" + Thread.currentThread().getName() + "): 售票，还剩 "
                + (--ticketNum) + " 张票~");
    }

    @Override
    public void run() {
        while (loop) {
            sell(); // sell方法是一个同步方法
        }
    }
}
