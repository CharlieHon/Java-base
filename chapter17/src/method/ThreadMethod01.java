package method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        // 测试相关的方法
        T t = new T();
        t.setName("bruce");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        // 主线程打印5hi，然后中断子线程休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }
        System.out.println(t.getPriority());    // 1
        t.interrupt();  // 当执行到这时，就会中断t线程的休眠
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // 当该线程得到一个 interrupt 方法时，就会catch一个异常，可以加入自己的业务代码
                // InterruptedException 是捕获一个中断异常
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}