package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 5, 2, 0, 2, 3};
        System.out.println("===排序前===");
        System.out.println(Arrays.toString(arr));
        System.out.println("===排序后===");
//        bubbleSort(arr);
        bubbleSort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1; // i2 - i1 > 0 即 i1 < i2 时进行交换，说明按照从大到小排序
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    // 结合冒泡 + 自定义
    public static void bubbleSort(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                // 排序的方式由 c.compare(arr[j], arr[j+1]) 返回值决定
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
