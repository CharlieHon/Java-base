package com.charlie.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 演示小球通过键盘控制上下左右移动 -> Java事件控制
 */
public class BallMove extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() throws HeadlessException {
        mp = new MyPanel();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
        // 窗口 JFrame 对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
    }
}

// KeyListener 监听器
class MyPanel extends JPanel implements KeyListener {

    // 为了让相求可以移动，把它的左上角的坐标设置为变量
    private int x = 10;
    private int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当某个键按下时，该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + " 被按下...");
        // 根据用户按下的不同键，来处理小球的移动(上下左右的键)
        // 在java中，会给每一个键，分配一个值(key)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {   // KeyEvent.VK_DOWN 就是向下的箭头对应的code
            y += 2;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 2;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 2;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 2;
        }

        // 让面板重绘，重绘后小圆球才会动起来！
        this.repaint();
    }

    // 当某个键松开(释放)时，触发该方法
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
