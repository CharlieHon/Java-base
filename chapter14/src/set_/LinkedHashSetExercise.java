package set_;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        Set<Car> set = new LinkedHashSet<>();
        set.add(new Car("奥托", 30000));
        set.add(new Car("奥迪", 500000));
        set.add(new Car("法拉利", 800000));
        set.add(new Car("奥托", 30000));
        set.add(new Car("夏利", 20000));
        System.out.println("set=" + set);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // 重写 equals 和 hashCode 方法
    // 当 name 和 price 相同时，则认为是同一个对象
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}