package com.charlie.sync;

import java.util.Scanner;

/**
 * 练习：
 *  A线程随机输出1~100之内的整数
 *  当B线程检测到输入 'Q' 时，A线程终止
 *  提示：B对象中要持有A对象，才可以通知A对象线程终止
 */
public class homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a); // 要把线程A的对象传入，才可以
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100) + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    private Scanner scanner = new Scanner(System.in);
    private A a;

    public B(A a) { // 构造器中，直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        // 接收到用户输入
        while (true) {
            System.out.print("请输入你的指令(Q表示退出)：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                // 以通知的方式，结束A线程
                this.a.setLoop(false);
                System.out.println(Thread.currentThread().getName() + "退出~");
                break;
            }
        }
    }
}