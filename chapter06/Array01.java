package chapter06;

import javafx.stage.StageStyle;

public class Array01 {
    public static void main(String[] args) {
        /** 数组可以存放多个同一类型的数据。数组也是一种数据类型，是引用类型。
         * 
         */
        // 定义一个数组
        // 1. double[] 表示是double类型的数组，数组名 hens
        // 2. {3, 5, 1, 3.4, 2, 50} 表示数组的值/元素，依次表示数组的第几个元素
        double[] hens = {3, 5, 1, 3.4, 2, 50};

        // 遍历数组得到数组的所有元素的和，使用for循环
        // 1. 通过下标 hens[下标] 来访问数组的元素
        // 2. 下标是从0开始编号的，第二个元素就是 hens[1]，依次类推
        double totalWeight = 0.;
        // 可以通过 数组名.length 得到数组的大小
        for (int i = 0; i < hens.length; ++i) {
            // System.out.println("第" + (i+1) + "个元素的值 = " + hens[i]);
            totalWeight += hens[i];
        }
        System.out.println("总体重 = " + totalWeight
            + "，平均体重 = " + (totalWeight/6));
    }
}