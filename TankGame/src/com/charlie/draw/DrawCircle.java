package com.charlie.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {    // JFrame对应窗口，可以理解为是一个画框
    // 定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        // 初始化面板
        mp = new MyPanel();
        // 把画板放入到窗口(画框)
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400, 300);
        // 当点击窗口的×时，程序就完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置为可显示
        this.setVisible(true);
    }
}

// 1. 先定义一个MyPanel，继承JPanel类，画图形就在面板上画
class MyPanel extends JPanel {
    /*
    1. MyPanel 对象就是一个画板
    2. Graphics g 可以理解为一支画笔
    3. Graphics 提供了很多绘图的方法
     */
    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g); // 调用父类的方法完成初始化
        // System.out.println("paint 方法被调用~");

        // 画出一个圆形
//        g.drawOval(10, 10, 100, 100);
        // 演示绘制不同的图形
//        g.drawLine(10, 10, 100, 100);
//        g.drawRect(10, 10, 100, 100);
        // 填充矩形
        // 设置画笔颜色
//        g.setColor(Color.cyan);
//        g.fillRect(100, 100, 200, 200);
//        g.fillOval(15, 15, 30, 30);

        // 画图片
        // 1. 获取图片资源    /ziling.png 表示在该项目的根目录去获取图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/ziling.png"));
        g.drawImage(image, 10, 10, 77, 90, this);

        // 画字符串
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 20));
        // 设置字体的位置，是字符串的左下角
        g.drawString("白云黄鹤道人家", 50, 50);
    }
}
