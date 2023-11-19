package com.hspedu;

public class Car {
    public String brand = "BMW";
    public int price = 50;
    public String color = "white";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
