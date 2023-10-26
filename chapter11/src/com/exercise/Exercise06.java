package com.exercise;

public class Exercise06 {
    public static void main(String[] args) {
        Car car = new Car(38);
        car.getAir().flow();
        Car car1 = new Car(-12);
        car1.getAir().flow();
        Car car2 = new Car(55);
        car2.getAir().flow();
    }
}


class Car {
    private double temperature;
    class Air { // 成员内部类
        public void flow() {
            if (temperature > 40) {
                System.out.println("冷风~");
            } else if (temperature < 0) {
                System.out.println("暖风...");
            } else {
                System.out.println("空调关闭...");
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    // 返回 Air 对象
    public Air getAir() {
        return new Air();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}