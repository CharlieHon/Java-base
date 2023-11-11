package threaduse;

public class Thread01 { // 通过继承 Thread类 创建线程
    public static void main(String[] args) throws InterruptedException {
        // 创建Cat对象，可以当作线程使用
        Cat cat = new Cat();
        // 源码解读：
        /*
        1.
            public synchronized void start() {
                start0();
            }
        2.  start0() 是本地方法，是JVM调用，底层是c/c++实现，真正实现多线程效果，是start0()，而不是run()
            private native void start0();
         */
        cat.start();    // 启动线程->执行cat的run()方法
//        cat.run();  // run()方法就是一个普通的方法，并没有真正地启动一个线程，就会把run方法执行完毕，才会执行下面方法
        // 说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        // 这时，主线程和子线程交替执行
        System.out.println("主线程继续执行：" + Thread.currentThread().getName());   // main
        for (int i = 1; i <= 60; i++) {
            System.out.println("主线程 i=" + i);
            Thread.sleep(1000);
        }
    }
}

// 1. 当一个类继承了 Thread类，该类就可以当成线程使用
// 2. 重写 run方法，写上自己的业务代码
// 3. run Thread类实现了 Runnable接口的 run方法
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() { //  重写 run方法，写上自己的业务代码
        while (true) {
            // 该线程每隔1秒，在控制台输出“喵喵，我是小猫咪”             Thread-0
            System.out.println("喵喵，我是小猫咪" + (++times) + " 线程名称：" + Thread.currentThread().getName());
            // 让该线程休眠1秒
            try {
                Thread.sleep(1000); // ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 80) {
                break;  // 当 times 到10次，退出while，线程也退出
            }
        }
    }
}