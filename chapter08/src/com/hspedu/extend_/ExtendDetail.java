package com.hspedu.extend_;

public class ExtendDetail {
    public static void main(String[] args) {
        System.out.println("===第一个对象===");
        Sub sub = new Sub();
//        sub.sayOK();
        System.out.println("===第二个对象===");
        Sub sub1 = new Sub("Jack", 23);
    }
}
