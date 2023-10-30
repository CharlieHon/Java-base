package com.date_;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        // 1. Calendar 类是 抽象类，并且构造器是 protected
        // 2. 可以通过 getInstance() 来获取实例
        // 3. 提供大量的方法和字段供使用
        // 4. Calendar 没有提供对象的格式化类，因此需要自己组合显式格式
        // 5. 如果使用24小时，则可以 Calendar.HOUR -> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance();
        System.out.println("c=" + c);   // 输出很多字段
        // 2. 获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1)); // 返回月数要加 1，因为默认按从0开始算
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));    // 30
        System.out.println("小时：" + c.get(Calendar.HOUR));   // 7
        System.out.println("分钟：" + c.get(Calendar.MINUTE)); // 34
        System.out.println("秒：" + c.get(Calendar.SECOND));  // 32
        // Calendar 没有专门的格式化方法，所以需要自己组合显式
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-"
                + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":"
                + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));    // 2023-10-30 19:40:35
    }
}
