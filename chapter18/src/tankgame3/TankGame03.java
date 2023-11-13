package tankgame3;

import javax.swing.*;

public class TankGame03 extends JFrame {    // JFrame对应窗口，理解为画框
    // 定义 MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame03 tk = new TankGame03();
    }

    public TankGame03() {
        mp = new MyPanel();
        // 将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);   // 把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.addKeyListener(mp);    // 让JFrame添加监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
