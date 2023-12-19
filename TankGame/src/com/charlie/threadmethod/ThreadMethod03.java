package com.charlie.threadmethod;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        // 希望当 main 线程结束后，子线程自动结束
        // 只需要将线程设置为守护线程即可
        myDaemonThread.setDaemon(true); // 先设置为守护线程，再启动
        myDaemonThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("同学们，大家起来");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (;;) {
            try {
                // 休眠 50ms
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("担负起天下的兴亡~");
        }
    }
}