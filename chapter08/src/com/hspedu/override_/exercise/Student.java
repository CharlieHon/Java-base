package com.hspedu.override_.exercise;

public class Student extends Person {
    private String id;
    private double score;
    public Student() {}
    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }
    public void say() {
        super.say();
        System.out.println("id：" + this.id + "，成绩：" + this.score);
    }
}
