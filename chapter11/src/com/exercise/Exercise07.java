package com.exercise;

public class Exercise07 {
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();

        Color color = Color.YELLOW;
        // switch () 中 放入枚举对象
        // 在每个 case 后，直接写上在枚举类中定义的枚举对象即可
        switch (color) {
            case RED:
                System.out.println("匹配到红色...");
                break;
            case BLUE:
                System.out.println("匹配到蓝色...");
                break;
            default:
                System.out.println("没有匹配到...");
        }
    }
}

interface IColor {
    void show();
}

enum Color implements IColor{

    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);

    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue + ", " +  greenValue + ", " + blueValue);
    }
}