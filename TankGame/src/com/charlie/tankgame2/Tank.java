package com.charlie.tankgame2;

public class Tank {
    private int x;  // 坦克的横坐标
    private int y;  // 坦克的纵坐标
    private int direct; // 坦克方向 0上 1右 2下 3左
    private int speed = 2;  // 坦克移动速度

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 上右下左移动方法
    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void modeLeft() {
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
