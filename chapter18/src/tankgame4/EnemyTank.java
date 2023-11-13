package tankgame4;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class EnemyTank extends Tank implements Runnable {
    // 敌方坦克数量多，可以放入到集合 Vector，因为考虑多线程问题
    Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void move() {
        // 根据坦克的方向继续移动
        switch (getDirect()) {
            case 0: // 向上
                // 让坦克保持一个方向，走30步
                for (int i = 0; i < 30; i++) {
                    moveUp();
                    // 休眠50毫秒
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 1: // 向右
                for (int i = 0; i < 30; i++) {
                    moveRight();
                    // 休眠50毫秒
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 2: // 向下
                for (int i = 0; i < 30; i++) {
                    moveDown();
                    // 休眠50毫秒
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            case 3: // 向左
                for (int i = 0; i < 30; i++) {
                    moveLeft();
                    // 休眠50毫秒
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            move();
            // 然后随机的改变坦克方向
            setDirect((int)(Math.random() * 4));    // [0, 1) -> [0, 4) -> 0,1,2,3
            // ！写并发程序，一定要考虑清除，该线程什么时候结束
            if (!isLive) {
                break;  // 退出线程
            }
        }
    }
}
