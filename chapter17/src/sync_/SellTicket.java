package sync_;

public class SellTicket {   // 使用多线程，模拟三个窗口同时售票100张
    public static void main(String[] args) {
        // 测试
//        SellTicket01 sellTicket1 = new SellTicket01();
//        SellTicket01 sellTicket2 = new SellTicket01();
//        SellTicket01 sellTicket3 = new SellTicket01();
//        // 启动线程，这里会出现票数超卖情况
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();

        // 实现接口 Runnable 同样会出现上述问题
//        System.out.println("===实现接口方式===");
//        SellTicket02 sellTicket02 = new SellTicket02();
//        Thread thread = new Thread(sellTicket02);
//        Thread thread1 = new Thread(sellTicket02);
//        Thread thread2 = new Thread(sellTicket02);
//        thread.start();
//        thread1.start();
//        thread2.start();

        // 测试 synchronized
        System.out.println("===测试synchronized===");
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}

// 实现接口方式，使用 synchronized
class SellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();

    // 同步方法(静态的)的锁为当前类本身
    // 1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
    // 2. 如果在静态方法中，实现一个同步代码块，synchronized (SellTicket03.class)
    public synchronized static void m1() {}

    public static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    // 1. public synchronized void sell() {} 就是一个同步方法
    // 2. 这时锁在 this对象
    // 3. 也可以在代码块上写 synchronized ，同步在代码块，互斥锁还是在 this对象
    public /*synchronized*/ void sell() {  // 同步方法，在同一时刻，只能有一个线程来执行run方法
        synchronized (/*this*/ object) {    // 可以是this对象，或者是同一个其它对象
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                setLoop(false); // 结束循环
                return;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票，剩余票数 " +
                    (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell(); // sell方法是一个同步方法
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

// 使用Thread方法
// 1. 创建线程的方法是 new SellTicket01
// 2. 此时 synchronized(this) {} 锁的不是同一个对象
class SellTicket01 extends Thread {
    private static int ticketNum = 100;   // 让多个线程共享 ticketNum

    public void m1() {
        synchronized (SellTicket03.class) { // synchronized(this)
            System.out.println("m1");
        }
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {   // 判断条件时同时跑进来
                System.out.println("售票结束...");
                break;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票，剩余票数 " +
                    (--ticketNum));
        }
    }
}

// 实现接口方法
class SellTicket02 implements Runnable {
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票，剩余票数 " +
                    (--ticketNum));
        }
    }
}