package chapter06;
import java.util.Scanner;
public class Array02 {
    public static void main(String[] args) {
        /** 数组的使用
         * 1. 动态初始化
         * - 数组的定义
         * 数据类型[] 数组名 = new 数据类型[大小]
         * int[] a = new int[5];    // 创建了一个数组，名字a，存放5个int
         * - 数组的引用(使用)
         * 数组名[下标/索引]
         */
        Scanner myScanner = new Scanner(System.in);
        double[] scores = new double[5];
        for (int i = 0; i < scores.length; ++i) {
            scores[i] = myScanner.nextDouble();
        }
        for (int i = 0; i < scores.length; ++i) {
            System.out.println("scores[" + i + "] = " + scores[i]);
        }

        /**
         * 2. 动态初始化
         * - 先声明数组
         * 数据类型 数组名[]；也可以 数据类型[] 数组名；如 int a[] 或 int[] a
         * - 创建数组
         * 数组名 = new 数据类型[大小]; a = new int[5];
         */
        double[] hens;  // 声明数组，还没有在内存中分配空间，hens是null
        hens = new double[6];   // 分配内存空间，可以存放数据

        /**
         * 3. 静态初始化
         * - 初始化数组
         * 数据类型[] 数组名 = {元素值1, 元素值2, ...};
         * int[] a = {4, 7, 6, 4, 5};   // 知道数组有多少元素，具体值
         * 相当于：int[] a = new int[5];
         * a[0] = 4; a[1] = 7; ..., a[4] = 5;
         */
    }
}
