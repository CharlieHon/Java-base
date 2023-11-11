package method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 " + Thread.currentThread().getName() + " 吃了 " + i + " 包子");
            if (i == 5) {
                System.out.println("主线程(小弟)让子线程(大哥)先吃");
                // join，线程插队
                t2.join();  // 这里相当于让 t2 线程先执行完毕，子线程全部执行完毕后返回
//                Thread.yield(); // 礼让，不一定成功
                System.out.println("子线程(大哥)吃完，主线程(小弟)接着吃");
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程 " + Thread.currentThread().getName() + " 吃了 " + i + " 包子");
        }
    }
}