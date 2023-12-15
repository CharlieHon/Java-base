package com.charlie.tankgame;

import javax.swing.*;
import java.awt.*;

public class TankGame01 extends JFrame {

    // 定义MyPanel
    private MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame01();
    }

    public TankGame01() throws HeadlessException {
        mp = new MyPanel();
        // 将画板添加到画框中
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 750);
        this.setVisible(true);
    }
}
