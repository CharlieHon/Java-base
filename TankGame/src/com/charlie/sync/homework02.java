package com.charlie.sync;

/**
 * 有2个用户分别从同一张卡上取钱
 * 每次都取1000.当余额不足时，就不能取款了
 * 不能出现超取现象
 */
public class homework02 {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        new Thread(bankCard).start();
        new Thread(bankCard).start();
    }
}

/*
1. 因为这里涉及到多个线程共享资源，所以使用实现 Runnable 方式
2. 每次取出 1000
 */
class BankCard implements Runnable {
    private int balance = 10000;
    private boolean loop = true;

    public void f() {
        /*
        1. 使用 synchronized 实现了线程同步
        2. 当多个线程执行到这里时，就会去争夺 this 对象锁
        3. 哪个线程得到 this对象锁，就执行 synchronized 代码块，执行完后，会释放this对象锁
        4. 拿不到this对象锁，就 blocked，准备继续争夺
         */
        synchronized (this) {
            if (balance < 1000) {
                System.out.println("余额不足...");
                loop = false;
                return;
            }
            balance -= 1000;
            System.out.println(Thread.currentThread().getName() + " 在取钱，余额：" + balance);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (loop) {
            f();
        }
    }
}
