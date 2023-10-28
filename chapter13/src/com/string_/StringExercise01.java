package com.string_;

public class StringExercise01 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));    // true 内容相同
        System.out.println(p1.name == p2.name); // true 指向相同的常量池 "hspedu"
        System.out.println(p1.name == "hspedu");    // true p1.name指向常量池的"hspedu"

        String s1 = new String("bruce");
        String s2 = new String("bruce");
        System.out.println(s1 == s2);   // false
    }
}

class Person {
    public String name;
}