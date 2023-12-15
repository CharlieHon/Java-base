package com.charlie.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 绘制背景(黑色、大小与画框相同)
        g.fillRect(0, 0, 1000, 750);

        // 画出坦克-封装到方法
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    /**
     * 编写方法，绘制坦克
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct    坦克方向(上下左右)
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        // 根据不同类型坦克，设置颜色
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克方向，绘制坦克
        switch (direct) {
            case 0: // 表示向上
                g.fill3DRect(x, y, 10, 60, false);  // 坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false);  // 坦克右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false);    // 坦克身子
                g.fillOval(x+10, y+20, 20, 20); // 坦克盖子
                g.drawLine(x+20, y, x+20, y+30);    // 画出炮筒
                break;
            case 1: // 向下

                break;
            case 2: // 向左
                break;
            case 3: // 向右
                break;
        }
    }
}
