package method;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread thread = new MyDaemonThread();
        thread.setDaemon(true); // 先设置为守护线程，再启动
        thread.start();
        // 将子线程设为守护线程时，当main线程结束后，子线程会自动结束
        for (int i = 1; i <= 10; i++) { // main
            System.out.println("呼呼哈嘿~");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {   // 守护线程：当所有用户线程结束，守护线程会自动结束
    @Override
    public void run() {
        for(; ;) {  // 无限循环
            System.out.println("功夫熊猫~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}