package com.charlie.tankgame2;

import javax.swing.*;
import java.awt.*;

public class TankGame02 extends JFrame {

    // 定义MyPanel
    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame02();
    }

    public TankGame02() throws HeadlessException {
        mp = new MyPanel();
        // 将画板添加到画框中
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setVisible(true);
        this.addKeyListener(mp);    // 让 JFrame 监听键盘事件
    }
}
