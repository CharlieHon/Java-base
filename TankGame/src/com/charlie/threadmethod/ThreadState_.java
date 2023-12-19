package com.charlie.threadmethod;

public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        System.out.println(t3.getName() + "线程，状态：" + t3.getState());    // NEW
        t3.start(); // Runnable

        while (Thread.State.TERMINATED != t3.getState()) {
            System.out.println(t3.getName() + "线程，状态：" + t3.getState());
            Thread.sleep(500);
        }
        System.out.println(t3.getName() + "线程，状态：" + t3.getState());    // TERMINATED
    }
}

class T3 extends Thread {
    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi~" + i);
                try {
                    Thread.sleep(1000);     // TIMED_WAITING
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
}
