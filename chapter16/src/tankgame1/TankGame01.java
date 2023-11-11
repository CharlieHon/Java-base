package tankgame1;

import javax.swing.*;

public class TankGame01 extends JFrame {    // JFrame对应窗口，理解为画框
    // 定义 MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tk = new TankGame01();
    }

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);   // 把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
