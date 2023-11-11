package tankgame1;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    // 坦克大战的绘图区域
    Hero hero = null;   // 定义自己的坦克
    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形，默认黑色

        // 绘制坦克-封装方法
        drawTank(hero.getX(), hero.getX(), g, 0, 0);
    }

    /**
     * 编写方法，绘制坦克
     * @param x 坦克的左上角x坐标
     * @param y 坦克左上角y坐标
     * @param g 画笔
     * @param direct    坦克方向(上下左右)
     * @param type      坦克类型：根据颜色区分
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0: // 我们的坦克
                g.setColor(Color.cyan); // 青色
                break;
            case 1: // 敌人坦克
                g.setColor(Color.yellow);
                break;
        }
        // 根据坦克方向，来绘制坦克
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false); // 右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); // 坦克盖子
                g.fillOval(x+10, y+20, 20, 20); // 圆盖
                g.drawLine(x+20, y, x+20, y+30);
                break;
            default:
                break;
        }
    }
}
