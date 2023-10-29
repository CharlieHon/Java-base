package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod01 {
    public static void main(String[] args) {
        // toString()
        Integer[] integers = {1, 8, 9, 5};
        System.out.println(Arrays.toString(integers));  // [1, 8, 9, 5]

        // sort()
        Integer[] arr = {1, -1, 7, 0, 89};
//        Arrays.sort(arr);   // 因为数组是引用类型，所以通过 sort 方法，会直接影响到实参 arr。默认升序排序
        System.out.println(Arrays.toString(arr));   // [-1, 0, 1, 7, 89]
        // sort()方法重载，通过传入一个接口 Comparator 实现自定义排序
        // 调用 自定义排序 时，传入两个参数 (1) 排序的数组 arr
        // (2) 实现了 Comparator 接口的匿名内部类，要求实现 compare 方法
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
//                return i1 - i2;   // 升序排序
                return i2 - i1;     // 降序排序
            }
        });
        System.out.println("===排序后===");
        System.out.println(Arrays.toString(arr));
    }
}
