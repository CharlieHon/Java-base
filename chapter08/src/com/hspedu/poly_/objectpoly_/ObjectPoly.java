package com.hspedu.poly_.objectpoly_;

public class ObjectPoly {
    public static void main(String[] args) {
        // animal 编译类型就是 Animal，运行类型是 Dog
        Animal animal = new Dog();
        // 因为运行时，执行到该行时，animal运行类型是Dog，所以cry就是Dog的cry
        animal.cry();   // Dog.cry()...
        animal = new Cat(); // 运行类型变为 Cat
        animal.cry();   // Cat.cry()...
    }
}
