package tankgame2;

import tankgame2.MyPanel;
import javax.swing.*;

public class TankGame02 extends JFrame {    // JFrame对应窗口，理解为画框
    // 定义 MyPanel
    tankgame2.MyPanel mp = null;
    public static void main(String[] args) {
        TankGame02 tk = new TankGame02();
    }

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);   // 把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.addKeyListener(mp);    // 让JFrame添加监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
