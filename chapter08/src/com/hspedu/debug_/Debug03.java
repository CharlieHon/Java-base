package com.hspedu.debug_;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 10, 20, 12};
        // 查看Arrays.sort()方法底层实现 -> debug
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("Hello100");
        System.out.println("Hello200");
        System.out.println("Hello300");
        System.out.println("Hello400");
    }
}
