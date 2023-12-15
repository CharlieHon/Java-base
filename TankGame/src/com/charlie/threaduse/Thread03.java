package com.charlie.threaduse;

/**
 * 练习
 * 在 main 线程启动两个子线程
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        new Thread(t1).start();
        new Thread(t2).start();
    }
}

class T1 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程(" + Thread.currentThread().getName() + "): hi~" + (++count));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (count == 5) {
                break;
            }
        }
    }
}

class T2 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程(" + Thread.currentThread().getName() + "): hello~" + (++count));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
