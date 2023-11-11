package threaduse;

public class Thread02 { // 如果实现接口 Runnable 开发线程
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); // 这里不能调用start
        // 创建了Thread对象，把dog对象(实现Runnable)，放入Thread
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal {}
class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}

// 线程代理类，模拟了一个极简的Thread类
class ThreadProxy implements Runnable {   // 可以把 ThreadProxy类 当作Thread类
    private Runnable target = null; // 属性，类型是 Runnable
    @Override
    public void run() {
        if (target != null) {
            target.run();   // 动态绑定，运行类型是传入的Runnable类型的参数
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();   // 这个方法是真正实现了多线程的方法
    }
    public void start0() {
        // ...
        run();
    }
}

class Dog implements Runnable { // 通过实现 Runnable 接口，开发线程
    int count = 0;
    @Override
    public void run() { // 普通方法，并没启动线程
        while (true) {
            System.out.println("小狗汪汪叫..." + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}