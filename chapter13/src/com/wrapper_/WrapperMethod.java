package com.wrapper_;

public class WrapperMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);  // -2147483648
        System.out.println(Integer.MAX_VALUE);  // 2147483647

        System.out.println(Character.isDigit('8')); // true 判断是否是数字
        System.out.println(Character.isLetter('A'));    // true 判断是否是字母
        System.out.println(Character.isUpperCase('a'));    // false 判断是否是大写
        System.out.println(Character.isLowerCase('a'));    // true 判断是否是小写

        System.out.println(Character.isWhitespace('a'));    // false 判断是否是空格
        System.out.println(Character.toUpperCase('d')); // D 转成大写
        System.out.println(Character.toLowerCase('X')); // x 转成小写
    }
}
