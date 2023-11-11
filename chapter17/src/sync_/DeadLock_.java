package sync_;

public class DeadLock_ {
    public static void main(String[] args) {
        // 模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // 1. 如果flag为true，线程A 就会得到/持有o1对象锁，然后尝试去获取o2对象锁
        // 2. 如果线程A 得不到o2对象锁，就会Blocked
        // 3. 如果flag为false，线程B 就会得到/持有o2对象锁，然后尝试去获取o1对象锁
        // 4. 如果线程B 得不到o1对象锁，就会Blocked
        if (flag) {
            synchronized (o1) { // 对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) { // 这里获得对象的监视权
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) { // 这里获得对象的监视权
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}