package method;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start(); // 创建/启动子线程
                thread.join();  // 子线程插队
                System.out.println("子线程结束");
            }
        }
        System.out.println("主线程结束");
    }
}

class T3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello " + i);
        }
    }
}