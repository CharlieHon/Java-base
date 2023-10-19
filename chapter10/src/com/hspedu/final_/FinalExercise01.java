package com.hspedu.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println(circle.getArea());
    }
}

class Circle {
    private double radius;  // 半径
    private final static double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius *radius;
    }
}