package com.string_;

public class StringMethod01 {
    public static void main(String[] args) {
        // 1. equals：比较内容是否相同，区分大小写
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);   // false
        // 2. equalsIgnoreCase：忽略大小写，判断内容是否相同
        String name1 = "Charlie";
        if ("charlie".equalsIgnoreCase(name1)) {
            System.out.println("Success!"); // Success!
        } else {
            System.out.println("Failure!");
        }
        // 3. length：获取字符的个数，即字符串的长度
        System.out.println("橘子".length());  // 2
        // 4. indexOf：获取字符/字符串在字符串对象中第一次出现的索引，索引从0开始，如果找不到则返回-1
        String s1 = "Bruce@gmail.com";
        System.out.println(s1.indexOf('@'));    // 5
        System.out.println(s1.indexOf("ce"));   // 3
        // 5. lastIndexOf：获取字符在字符串对象中最后依次出现的索引，索引从0开始，如果没有返回-1
        s1 = "Bruce@com@";
        System.out.println(s1.lastIndexOf('@'));    // 9
        // 6. subString：截取指定范围的子串
        String name2 = "hello,张三";
        System.out.println(name2.substring(6)); // 从索引6开始截取后面所有内容
        System.out.println(name2.substring(2, 5));  // 截取索引[beginIndex, endIndex)范围的内容
    }
}
