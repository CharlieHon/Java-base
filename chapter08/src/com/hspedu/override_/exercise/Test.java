package com.hspedu.override_.exercise;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("Jack", 22);
        Student student = new Student("Charlie", 21, "123456", 99);
        person.say();
        student.say();
    }
}
