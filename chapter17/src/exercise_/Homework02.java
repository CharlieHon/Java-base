package exercise_;

public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a);
        Thread thread1 = new Thread(a);
        thread.setName("线程A");
        thread1.setName("线程B");
        thread.start();
        thread1.start();
    }
}

// 因为这里涉及多个线程共享资源，所以通过实现Runnable接口方式
class A implements Runnable {
    private static int money = 10000;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            // 1. 使用 synchronized 实现了线程同步
            // 2. 当多个线程执行到这里时，就会去争夺 object/this对象锁
            // 3. 哪个线程争夺/获取到，就执行 synchronized代码块
            // 4. 争夺不到对象锁，就blocked，准备继续争夺
            // 5. this对象是非公平锁
            synchronized (this/*object*/) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (money < 1000) {
                    System.out.println("余额不足...");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "-取款1000元，余额" + money);
            }
        }
    }
}