package com.bignum_;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        // 当需要保存一个精度很高的数时，double精度不够用，可以使用 BigDecimal
        double d = 19.1234567895244666666666d;
        System.out.println(d);  // 19.123456789524468
        BigDecimal bigDecimal = new BigDecimal("19.1234567895244666666666");
        System.out.println(bigDecimal); // 19.1234567895244666666666
        BigDecimal bigDecimal1 = new BigDecimal("1.1");
        // 1. 对 BigDecimal 进行运算，比如加减乘除，需要使用对应的方法
        // 2. 创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
//        System.out.println(bigDecimal.divide(bigDecimal1)); // 可能抛出异常 ArithmeticException 除不尽
        // 在调用 divide 方法时，指定精度即可 BigDecimal.ROUND_CEILING
        // 如果有无线循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING));
    }
}
