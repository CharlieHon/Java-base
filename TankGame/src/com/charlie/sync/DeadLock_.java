package com.charlie.sync;

public class DeadLock_ {
    public static void main(String[] args) {
        // 模拟死锁
        DeadLockDemo a = new DeadLockDemo(true);
        a.setName("A");
        DeadLockDemo b = new DeadLockDemo(false);
        b.setName("B");

        a.start();
        b.start();
    }
}

class DeadLockDemo extends Thread {
    public static Object o1 = new Object();
    public static Object o2 = new Object();
    private boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        /*
        1. 如果 flag 为 T，线程 A就会先得到/持有 o1 对象锁，然后尝试去获取 o2 对象锁
        2. 如果线程A得不到 o2 对象锁，就会 Blocked
        3. 如果 flag 为 F，线程 B就会先得到/持有 o2 对象锁，然后尝试去获取 o1 对象锁
        4. 如果线程B得不到 o1 对象锁，就会 Blocked
         */
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}
