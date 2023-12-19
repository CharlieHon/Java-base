package com.charlie.exit_;

public class ThreadExit_ {
    public static void main(String[] args) {
        T t1 = new T();
        t1.start();

        // 如果希望主线程main线程去控制t1线程的终止，必须可以修改 loop
        // 让 t1 退出 run() 从而终止 t1线程 -> 通知方式
        try {
            // 让主线程休眠10s再通知子线程退出
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    // 设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            System.out.println("线程(" + Thread.currentThread().getName() + "): " + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
