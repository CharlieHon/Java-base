package com.hspedu.pkg;

// 建议：需要使用到哪个类，就导入哪个类即可，不建议使用 * 导入
import java.util.Arrays;
import java.util.Scanner;   // 表示只会引入java.util包下的Scanner
//import java.util.*;         // 表示将java.util包下的所有类到导入

public class Import01 {
    public static void main(String[] args) {
        // 使用系统提供 Arrays 完成数组排序
        int[] arr = {-1, 8, 9, 5};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
