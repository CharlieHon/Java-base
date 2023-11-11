package exercise_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        /*
        1. 在main方法中启动两个线程
        2. 在第一个线程循环随机打印100以内的整数
        3. 直到第3个线程从键盘读取了 "Q" 命令
         */
        T1 t1 = new T1();
        t1.setName("线程A");
        t1.start();
        T2 t2 = new T2(t1); // 要把线程A传给线程B才行！
        t2.setName("线程B");
        t2.start();
    }
}

class T1 extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        // 输出1-100数字
        while (loop) {
            System.out.println(Thread.currentThread().getName() + "-" + (int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "-退出...");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class T2 extends Thread {
    private T1 t1;
    private Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {  // 构造器，直接传入T1类对象
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            // 接受用户的输入
            System.out.println("请输入指令(Q表示退出)：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                // 以通知的方式结束 T1进程
                t1.setLoop(false);
                System.out.println(Thread.currentThread().getName() + "-退出...");
                break;  // 本线程退出
            }
        }
    }
}