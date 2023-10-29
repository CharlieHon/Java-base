package com.arrays_;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 6, 10, 22, 63};
        // binarySearch：通过二分搜索进行查找，要求必须有序
        // 1. 使用 binarySearch 二分查找
        // 2. 要求该数组是有序的，如果该数组无序，则不能使用
        // 3. 如果数组中不存在该元素，则返回 如果存在是应处位置 low -> -(lor + 1)
        int index = Arrays.binarySearch(arr, 16);
        System.out.println("index=" + index);

        // copyOf：数组元素的数值
        // 1. 从 arr 数组中，拷贝 arr.length 个元素到 newArr 数组中
        // 2. 如果拷贝的长度 > arr.length ，就在新数组的后面，增加 null
        // 3. 如果拷贝长度 < 0，抛出异常
        // 4. 该方法的底层使用的是 System.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));    // [1, 2, 6, 10, 22, 63]

        // fill：数组元素的填充
        // 1. 使用 key:99 去填充 num 数组，可以理解为替换原数组元素
        Integer[] num = new Integer[]{10, 7, 5};
        Arrays.fill(num, 99);
        System.out.println("===num数组填充后===");
        System.out.println(Arrays.toString(num));   // [99, 99, 99]

        // equals：比较两个数组元素内容是否完全一致
        // 1. 如果 arr 和 arr2 数组中元素完全一样，则方法返回 ture；否则返回 false
        Integer[] arr2 = new Integer[]{1, 2, 6, 10, 22, 63};
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println(equals); // true

        // asList：将一组值，转换成 list
        // 1. asList方法，会将 (2, 5, 9, 7) 数据转成一个 List 集合
        // 2. 返回的 asList 编译类型是 List(接口)
        // 3.       asList 运行类型是 java.util.Arrays$ArrayList
        // Arrays 的静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //                      implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2, 5, 9, 7);
        System.out.println("asList=" + asList); // asList=[2, 5, 9, 7]
        System.out.println("asList.getClass()=" + asList.getClass());   // class java.util.Arrays$ArrayList
    }
}
