package tankgame4;

public class Shot implements Runnable {
    private int x;  // 子弹x坐标
    private int y;  // 子弹x坐标
    private int direct = 0; // 子弹方向
    private int speed = 2;  // 子弹速度
    private boolean isLive = true;  // 子弹是否还存活

    // 构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { // 射击行为
        while (true) {
            try {
                Thread.sleep(50);  // 线程休眠
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 根据方向来改变x,y坐标
            switch (direct) {   // 0上,1右,2下,3左
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            // 测试，这里输出xy坐标
            System.out.println("子弹坐标：(" + x + ", " + y + ")");
            // 当子弹移动到面板的边界时，就应该销毁(把启动的子弹的线程销毁)
            // 当子弹碰到敌方坦克时，也应该结束线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive())) {
                isLive = false;
                System.out.println("子弹线程退出");
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
