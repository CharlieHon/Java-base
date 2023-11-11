package ticket_;

public class SellTicket {   // 使用多线程，模拟三个窗口同时售票100张
    public static void main(String[] args) {
        // 测试
//        SellTicket01 sellTicket1 = new SellTicket01();
//        SellTicket01 sellTicket2 = new SellTicket01();
//        SellTicket01 sellTicket3 = new SellTicket01();
//        // 启动线程，这里会出现票数超卖情况
//        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();

        // 实现接口 Runnable 同样会出现上述问题
        System.out.println("===实现接口方式===");
        SellTicket02 sellTicket02 = new SellTicket02();
        Thread thread = new Thread(sellTicket02);
        Thread thread1 = new Thread(sellTicket02);
        Thread thread2 = new Thread(sellTicket02);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

// 使用Thread方法
class SellTicket01 extends Thread {
    private static int ticketNum = 100;   // 让多个线程共享 ticketNum
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {   // 判断条件时同时跑进来
                System.out.println("售票结束...");
                break;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票，剩余票数 " +
                    (--ticketNum));
        }
    }
}

// 实现接口方法
class SellTicket02 implements Runnable {
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            // 休眠50毫秒，模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票，剩余票数 " +
                    (--ticketNum));
        }
    }
}