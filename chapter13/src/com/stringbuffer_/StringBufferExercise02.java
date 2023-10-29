package com.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        // 将商品价格格式化，价格的小数点前面每三位用逗号隔开
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品价格：");
        String priceStr = scanner.next();
        StringBuffer sb = new StringBuffer(priceStr);   // String -> StringBuffer
        int index = sb.lastIndexOf(".");
        int len = sb.length();
        if (index != -1) {  // 有小数部分
            while (index - 3 > 0) {
                index -= 3;
                sb.insert(index, ',');
            }
        } else {    // 没有小数部分
            while (len - 3 > 0) {
                len -= 3;
                sb.insert(len, ',');
            }
        }
        System.out.println(sb);
    }
}
