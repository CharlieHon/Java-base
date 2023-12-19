package com.charlie.threadmethod;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("hi~" + i);
            Thread.sleep(1000);
            if (i == 4) {
                // 线程插队，一定会成功
                // 让 t1 线程(插队)先执行完毕，才继续执行 main 线程
//                t1.join();

                // 礼让，不一定成功
                Thread.yield();
            }
        }
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello~" + i);
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
