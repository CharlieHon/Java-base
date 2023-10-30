package com.bignum_;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {
        // 当编程中需要处理很大的整数，long不够用，可以使用 BigInteger 类
        BigInteger bigInteger = new BigInteger("999999991234567891236549871423");
        BigInteger bigInteger1 = new BigInteger("100");
        System.out.println(bigInteger); // 999999991234567891236549871423
        // 1. 在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        // 2. 可以创建一个要操作的 BigInteger 然后进行响应操作
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);
        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract);
        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);
        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide);
    }
}
