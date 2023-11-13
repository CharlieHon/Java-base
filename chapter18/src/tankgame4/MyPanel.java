package tankgame4;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

// 为了监听键盘事件，实现 KeyListener接口
// 为了让Panel不停的重绘子弹，需要将MyPanel实现Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 坦克大战的绘图区域
    Hero hero = null;   // 定义自己的坦克
    // 定义敌方坦克，放入Vector中，线程安全
    Vector<EnemyTank> enemyTanks = new  Vector<>();
    // 定义一个Vector，用于存放炸弹
    // 说明，当子弹击中坦克时，就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    // 定义三张炸弹图片，用于显示炸弹效果
    Image img1 = null;
    Image img2 = null;
    Image img3 = null;

    public MyPanel() {
        hero = new Hero(100, 100);
//        hero.setSpeed(5);   // 设置坦克速度
        // 初始化敌方坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建一个敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            // 设置方向
            enemyTank.setDirect(2);
            // 启动敌方坦克线程，让其动起来
            new Thread(enemyTank).start();
            // 给该enemyTank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX()+20, enemyTank.getY()+60, enemyTank.getDirect());
            // 加入enemyTank地Vector成员
            enemyTank.shots.add(shot);
            // 立即启动shot对象
            new Thread(shot).start();
            // 加入
            enemyTanks.add(enemyTank);
        }
        // 初始化图片对象
        img1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        img2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        img3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形，默认黑色

        // 绘制坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        // 画出Hero射击的子弹
        if (hero.shot != null && hero.shot.isLive()) {
            // g.fill3DRect(hero.shot.getX(), hero.shot.getY(), 1, 1, false);
            g.draw3DRect(hero.shot.getX(), hero.shot.getY(), 1, 1, false);
        }
        
        // 如果 bombs 集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            // 取出炸弹
            Bomb bomb = bombs.get(i);
            // 根据当前bomb对象的life值画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(img1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(img2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(img3, bomb.x, bomb.y, 60, 60, this);
            }
            // 让炸弹生命值减少
            bomb.lifeDown();
            // 如果bomb的life为0，就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        // 绘制敌方坦克
        for (EnemyTank enemy :
                enemyTanks) {
            if (enemy.isLive()) {   // 只要当敌方坦克存货才绘制
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
                // 画出 enemy 所有子弹
                for (int i = 0; i < enemy.shots.size(); i++) {
                    Shot shot = enemy.shots.get(i);
                    // 绘制
                    if (shot.isLive()) {    // isLive() == true
                        g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
                    } else {
                        // 从Vector移除
                        enemy.shots.remove(shot);
                    }
                }
            }
        }
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

    // 编写方法，判断我方子弹是否击中敌方坦克
    // 什么时候判断 我方坦克是否击中敌方坦克？run方法
    public void hitTank(Shot s, EnemyTank enemyTank) {
        // 判断s击中坦克
        switch (enemyTank.getDirect()) {
            case 0: // 坦克向上
            case 2: // 坦克向下
                if (s.getX() > enemyTank.getX() && s.getX() < (enemyTank.getX() + 40)
                        && s.getY() > enemyTank.getY() && s.getY() < (enemyTank.getY() + 60)) {
                    s.setLive(false);
                    enemyTank.setLive(false);
                    // 当我方击中敌方坦克时，将enemyTank从Vector中去除
                    enemyTanks.remove(enemyTank);
                    // 创建Bomb对象，加入到bombs集合
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
                break;
            case 1: // 向右
            case 3: // 向左
                if (s.getX() > enemyTank.getX() && s.getX() < (enemyTank.getX() + 60)
                        && s.getY() > enemyTank.getY() && s.getY() < (enemyTank.getY() + 20)) {
                    s.setLive(false);
                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
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
        // 如果用户按下的是J，就需要发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下J键");
            hero.shotEnemyTank();
        }
        // 重绘画板
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { // 每个100毫秒，重绘区域，刷新绘图区域子弹就会移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否击中敌方坦克
            if (hero.shot != null && hero.shot.isLive()) {
                // 遍历敌人所有的坦克
//                for (EnemyTank enemyTank :
//                        enemyTanks) {
//                    hitTank(hero.shot, enemyTank);
//                }
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                }
            }
            this.repaint();
        }
    }
}
