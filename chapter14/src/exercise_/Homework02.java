package exercise_;

import java.util.ArrayList;

public class Homework02 {
    public static void main(String[] args) {
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        Car car3 = new Car("丰田", 150000);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.remove(car3);
        System.out.println(cars.contains(car3));    // false
        System.out.println(cars.size());    // 2
        System.out.println(cars.isEmpty()); // false
        cars.clear();
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Car("劳斯莱斯", 10000000));
        list.add(new Car("保时捷", 20000000));
        cars.addAll(list);
        for (Car car : cars) {
            System.out.println(car);
        }

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "-$" + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}