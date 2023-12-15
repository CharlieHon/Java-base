package com.charlie.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 * 为了监听键盘事件，实现 KeyListener
 */
public class MyPanel extends JPanel implements KeyListener {

    // 定义我的坦克
    Hero hero = null;
    // 定义敌方坦克，放入到 Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
//        hero.setSpeed(3);   // 设置坦克移动速度

        // 初始化敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建一个敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 + i * 100, 0);
            // 设置方向
            enemyTank.setDirect(2); // 坦克炮筒方向向下
            // 加入到集合中
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 绘制背景(黑色、大小与画框相同)
        g.fillRect(0, 0, 1000, 750);

        // 画出坦克-封装到方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        // 画出敌方坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
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
            case 0: // 我方坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌方坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克方向，来绘制对应形状的坦克
        // direct 表示方向(0:向上, 1:向右, 2:向下, 3:向左)
        // 坦克方向改变时，左上角坐标保持不变
        switch (direct) {
            case 0: // 表示向上
                g.fill3DRect(x, y, 10, 60, false);  // 坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false);  // 坦克右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false);    // 坦克身子
                g.fillOval(x+10, y+20, 20, 20); // 坦克盖子
                g.drawLine(x+20, y, x+20, y+30);    // 画出炮筒
                break;
            case 1: // 向右
                g.fill3DRect(x, y, 60, 10, false);  // 坦克上边轮子
                g.fill3DRect(x, y+30, 60, 10, false);  // 坦克下边轮子
                g.fill3DRect(x+10, y+10, 40, 20, false);    // 坦克身子
                g.fillOval(x+20, y+10, 20, 20); // 坦克盖子
                g.drawLine(x+30, y+20, x+60, y+20);    // 画出炮筒
                break;
            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, false);  // 坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false);  // 坦克右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false);    // 坦克身子
                g.fillOval(x+10, y+20, 20, 20); // 坦克盖子
                g.drawLine(x+20, y+60, x+20, y+30);    // 画出炮筒
                break;
            case 3: // 向左
                g.fill3DRect(x, y, 60, 10, false);  // 坦克上边轮子
                g.fill3DRect(x, y+30, 60, 10, false);  // 坦克下边轮子
                g.fill3DRect(x+10, y+10, 40, 20, false);    // 坦克身子
                g.fillOval(x+20, y+10, 20, 20); // 坦克盖子
                g.drawLine(x+30, y+20, x, y+20);    // 画出炮筒
                break;
            default:
                System.out.println("暂时不做处理...");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理 wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            // 改变坦克方向
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.modeLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        }
        this.repaint(); // 面板重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
