package threaduse;

public class Thread03 { // 在main线程启动两个子线程
    public static void main(String[] args) {
        T1 t1 = new T1(50, "hello, world");
        T1 t2 = new T1(60, "hi");
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        System.out.println("OK~");
    }
}

// 每隔1秒输出
class T1 implements Runnable {
    private int cnt = 0;
    private int count;
    private final String content;

    public T1(int count, String content) {
        this.count = count;
        this.content = content;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(content + "-" + (++cnt));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cnt == count) {
                break;
            }
        }
    }
}