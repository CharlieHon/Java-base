package chapter06;

public class Array03 {
    public static void main(String[] args) {
        // 1. 数组是多个相同数据类型的组合，实现对这些数据的统一管理
        int[] arr1 = {1, 2, 3, 4, 5};
        double[] arr2 = {3.1, 5, 6, 7.8};

        // 2. 数组中的元素可以是任意数据类型，包括基本数据类型和引用类型，但是不能混用
        String[] arr3 = {"北京", "欢迎", "You"};

        // 3. 数组创建后，如果没有赋值，有默认值。
        // int, short, byte, long -> 0
        // float, double -> 0.0
        // char -> \u0000   unicode编码为0的值
        // boolean -> false
        // String -> null
        short[] arr4 = new short[3];    // [0] [0] [0]
        for (int i = 0; i < arr4.length; ++i)
            System.out.println(arr4[i]);    // 0

        // 4. 数组下标必须在指定范围内使用，否则报错：下标越界异常
        // 数组的下标/索引 [0, length)
        int[] arr5 = new int[5];
        // System.out.println(arr5[5]);    // 编译不检查，运行会报错

        // 5. 数组属于引用类型，数组型数据是对象(object)
    }
}
