package com.hspedu.override_.exercise;

public class Person {
    private String name;
    private int age;
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void say() {
        System.out.println("我是" + this.name + "，今年" +
                this.age + "岁");
    }
}
