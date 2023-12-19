package com.charlie.threadmethod;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("Charlie");   // 设置线程名称
        t.setPriority(Thread.MIN_PRIORITY); // 设置线程优先级
        t.start();  // 启动线程

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi~ " + i);
        }

        System.out.println("线程" + t.getName() +  "的优先级：" + t.getPriority());   // 1

        // 当执行到这里是，就会中断 t线程 的休眠
        // 线程t休眠被中断后，会继续执行 run() 方法中后续的代码
        t.interrupt();
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " 线程~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 正在休眠");
                Thread.sleep(20 * 1000);    // 休眠20s
            } catch (InterruptedException e) {
                // 当线程执行到一个 interrupt 方法时，就会catch一个异常，可以加入自己的业务代码
                System.out.println(Thread.currentThread().getName() + " 被 interrupt...");
            }
        }
    }
}
