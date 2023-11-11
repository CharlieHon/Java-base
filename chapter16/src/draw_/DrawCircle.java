package draw_;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {    // JFrame 对应窗口，可以理解为画框
    // 定义一个画板
    private MyPanel mp = null;

    public static void main(String[] args) {
        // 演示如果在面板上画出圆形
        new DrawCircle();
    }

    public DrawCircle() {
        // 初始化面板
        mp = new MyPanel();
        // 把面板放入到窗口(画框)
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 当点击窗口×时，退出程序
        this.setVisible(true);  // 可以显示
    }
}

// 1. 先定义一个MyPanel，继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel {
    private static int cnt = 0;
    // 说明
    // 1. MyPanel对象就是一个画板
    // 2. Graphics g 把 g 理解成一支画笔
    // 3. Graphics 提供了很多绘图的方法

    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g); // 调用父类方法完成初始化
        cnt++;
        System.out.println("paint()方法被调用..." + cnt + "次");
        // 画出一个椭圆形
//        g.drawOval(0, 0, 100, 100);
        // 演示绘制不同的图形
        // 绘制直线
//        g.drawLine(10, 10, 100, 100);
        // 绘制矩形边框
//        g.drawRect(10, 10, 100, 100);
        // 设置画笔颜色
//        g.setColor(Color.blue);
        // 填充矩形
//        g.fillRect(10, 10, 100, 100);
        // 填充椭圆
//        g.fillOval(10, 10, 50, 50);
        // 画图片
        // 1. 获取图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/ikun.png"));
//        g.drawImage(image, 10, 10, 135, 138, this);
        // 画字符串
        // 设置画笔颜色
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 20));   // 字体，粗体，大小
        g.drawString("人民万岁", 100, 100); // 起设置的位置是字体的左下角
        g.drawLine(100, 100, 200, 100);
    }
}