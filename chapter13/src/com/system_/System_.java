package com.system_;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        // exit：退出当前程序
        System.out.println("OK");
        // 1. exit(0) 表示程序退出
        // 2. 0 表示一个状态，正常的状态
//        System.exit(0);
//        System.out.println("OK~");

        // System.arraycopy：数组拷贝
        int[] src = {1, 2, 3};
        int[] dest = new int[3];    // dest 当前是 {0, 0, 0}
        /* 5个参数的含义
           src：源数组
         * @param      src      the source array.
           srcPos：从源数组哪个索引位置开始拷贝
         * @param      srcPos   starting position in the source array.
           dest：目标数组，即把源数组的数据拷贝到哪个数组
         * @param      dest     the destination array.
           destPos：拷贝到目标数组的开始索引位置
         * @param      destPos  starting position in the destination data.
            length：从源数组拷贝多少个数据到目标数组
         * @param      length   the number of array elements to be copied.
         */
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));  // [1, 2, 3]

        // currentTimeMillis：返回从1970-01-01到当前时间的毫秒数
        System.out.println(System.currentTimeMillis());
    }
}
