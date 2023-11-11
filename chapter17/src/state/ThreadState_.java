package state;

public class ThreadState_ {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());    // NEW
        t.start();  // Runnable

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
        }
        System.out.println(t.getName() + " 状态 " + t.getState());    // TERMINATED
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}