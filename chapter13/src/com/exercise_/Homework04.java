package com.exercise_;

public class Homework04 {
    public static void main(String[] args) {
        /*
        输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
         */
        String name = "sdaADD44dasW@8^";
        method(name);
    }

    public static void method(String name) {
        if (name == null) {
            System.out.println("字符串为空");
            return;
        }
        char[] value = name.toCharArray();  // 可以不用转换成数组
        int upperCnt = 0, lowerCnt = 0, digitCnt = 0, otherCnt = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] >= '0' && value[i] <= '9') {
                ++digitCnt;
            } else if (value[i] >= 'a' && value[i] <= 'z') {
                ++lowerCnt;
            } else if (value[i] >= 'A' && value[i] <= 'Z') {
                ++upperCnt;
            } else {
                ++otherCnt;
            }
        }
        System.out.println(String.format("小写字母：%d个，大写字母：%d个，数字：%d个，其它：%d个", lowerCnt, upperCnt, digitCnt, otherCnt));
    }
}
