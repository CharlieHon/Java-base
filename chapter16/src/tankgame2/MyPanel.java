package tankgame2;

import jdk.nashorn.internal.ir.CallNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

// 为了监听键盘事件，实现 KeyListener接口
public class MyPanel extends JPanel implements KeyListener {
    // 坦克大战的绘图区域
    Hero hero = null;   // 定义自己的坦克
    // 定义敌方坦克，放入Vector中，线程安全
    Vector<EnemyTank> enemyTanks = new  Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
//        hero.setSpeed(5);   // 设置坦克速度
        // 初始化敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建一个敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            // 设置方向
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形，默认黑色

        // 绘制坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        // 绘制敌方坦克
        for (EnemyTank enemy :
                enemyTanks) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
        }
//        drawTank(hero.getX()+50, hero.getY(), g, 1, 1);
//        drawTank(hero.getX(), hero.getY()+50, g, 2, 1);
//        drawTank(hero.getX()+50, hero.getY()+50, g, 3, 1);
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
            case 0: // 敌方坦克
                g.setColor(Color.cyan); // 青色
                break;
            case 1: // 我方坦克
                g.setColor(Color.yellow);
                break;
        }
        // 根据坦克方向，来绘制对应形状坦克
        // direct 表示方向(0：向上, 1：向右, 2：向下, 3：向左)
        switch (direct) {
            case 0: // 代表向上
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false); // 右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); // 坦克盖子
                g.fillOval(x+10, y+20, 20, 20); // 圆盖
                g.drawLine(x+20, y, x+20, y+30);
                break;
            case 1: // 代表向右
                g.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                g.fill3DRect(x, y+30, 60, 10, false); // 下边轮子
                g.fill3DRect(x+10, y+10, 40, 20, false); // 坦克盖子
                g.fillOval(x+20, y+10, 20, 20); // 圆盖
                g.drawLine(x+30, y+20, x+60, y+20);    // 炮筒
                break;
            case 2: // 代表向下
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x+30, y, 10, 60, false); // 右边轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); // 坦克盖子
                g.fillOval(x+10, y+20, 20, 20); // 圆盖
                g.drawLine(x+20, y+60, x+20, y+30);
                break;
            case 3: // 代表向左
                g.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                g.fill3DRect(x, y+30, 60, 10, false); // 下边轮子
                g.fill3DRect(x+10, y+10, 40, 20, false); // 坦克盖子
                g.fillOval(x+20, y+10, 20, 20); // 圆盖
                g.drawLine(x+30, y+20, x, y+20);    // 炮筒
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理 wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {  // 向上
            // 改变坦克方向
            hero.setDirect(0);
            // 修改坦克的坐标
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {   // 向左
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {   // 向下
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {   // 向右
            hero.setDirect(1);
            hero.moveRight();
        }
        // 重绘画板
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
