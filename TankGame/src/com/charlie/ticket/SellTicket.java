package com.charlie.ticket;

/**
 * 使用多线程，模拟三个窗口同时售票 100 张
 */
public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        // 这里会出现超卖的情况
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();

//        System.out.println("========实现Runnable接口方式========");
//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();   // 第1个线程
//        new Thread(sellTicket02).start();   // 2
//        new Thread(sellTicket02).start();   // 2
    }
}

// 使用 Thread
class SellTicket01 extends Thread {

    private static int ticketNum = 100;   // 让多个线程共享 ticketNum
    private static boolean loop = true;

    public void sell() {
        synchronized (SellTicket01.class) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
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
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}

class SellTicket02 implements Runnable {

    // 只创建一个 SellTicket02 对象，不必设为静态属性
    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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
    }
}
