package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {  // 窗口
    // 演示小球通过键盘控制上下左右移动 -> Java事件控制
    private MyPanel mp = null;  // 画板
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        // 窗口 JFrame对象 可以监听键盘事件，即可以监听到面板发生的事件
        this.addKeyListener(mp);    // 将实现了 KeyListener接口 的对象
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

// KeyListener 是一个监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    // 为了让小球可以移动，把它的左上角坐标(x, y)设为变量
    private int x = 10;
    private int y = 10;
//    private int width = 20;
//    private int height = 20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.fillOval(x, y, width, height);
        g.fillOval(x, y, 20, 20);
    }

    // 有字符输入时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当某个键按下时，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被按下...");
        // 根据用户按下的不同键，来处理小球的移动(上下左右的键)
        // 在Java中，会给每个键分配一个 int 值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        // 让面板重绘
        this.repaint();
    }

    // 当某个键释放(松开)
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}