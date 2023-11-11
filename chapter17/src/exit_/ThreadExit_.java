package exit_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();
        // 如果希望主线程main去控制t1线程的终止，必须可以修改loop
        // 让t1退出run方法，从而终止t1线程 -> 通知方式
        Thread.sleep(10 * 1000);    // 让主线程休眠10秒，再通知t1线程
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread-0
//            System.out.println(Thread.currentThread().getName());
            System.out.println("T 运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}