package com.hspedu.interface_;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        AB ab = new AB();
        System.out.println(AAA.a);  // 10
        System.out.println(ab.a);   // 10
        System.out.println(AB.a);   // 10
    }
}

interface AAA {
    int a = 10; // public static final int a = 10;
}

class AB implements AAA {}