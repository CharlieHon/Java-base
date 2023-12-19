package com.charlie.threadmethod;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new T2());
        for (int i = 0; i < 10; i++) {
            System.out.println("hi~" + i);
            Thread.sleep(1000);
            if (i == 4) {
                t.start();  // 启动子线程，输出 hello
                t.join();   // 立即将 t 子线程限制性
            }
        }
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}