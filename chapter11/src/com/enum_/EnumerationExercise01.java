package com.enum_;

public class EnumerationExercise01 {
    public static void main(String[] args) {
        Gender g1 = Gender.BOY;
        System.out.println(g1); // BOY  调用父类 Enum 类的 toString()
        Gender g2 = Gender.BOY;
        System.out.println(g1 == g2);   // true
    }
}

enum Gender {   // 枚举类，没有属性
    BOY, GIRL;  // 有两个枚举对象，BOY，GIRL，使用无参构造器创建
}
