package com.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        // 第三代日期
        // 1. now()：返回表示当前日期时间的对象
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);    // 2023-10-30T19:43:50.047

        // 2. 使用 DateTimeFormatter 对象进行格式化
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println(format);    // 2023-10-30 19:58:18

        System.out.println("年：" + ldt.getYear());   // 年：2023
        System.out.println("月：" + ldt.getMonth());  // 月：OCTOBER
        System.out.println("月：" + ldt.getMonthValue()); // 月：10
        System.out.println("日：" + ldt.getDayOfMonth()); // 日：10
        System.out.println("时：" + ldt.getHour()); // 时：19
        System.out.println("分：" + ldt.getMinute()); // 分：49
        System.out.println("秒：" + ldt.getSecond()); // 秒：39

        LocalDate now = LocalDate.now();    // 获取年月日
        System.out.println(now);    // 2023-10-30

        LocalTime now1 = LocalTime.now();   // 获取时分秒
        System.out.println(now1);   // 19:51:32.821

        // 提供了大量的 plus 和 minus 方法可以对当前的时间进行加或者减
        LocalDateTime localDateTime = ldt.plusDays(100);
        System.out.println("100天后是" + dateTimeFormatter.format(localDateTime)); // 100天后是2024-02-07 20:05:49

        LocalDateTime localDateTime1 = ldt.minusDays(100);
        System.out.println("100天前是" + dateTimeFormatter.format(localDateTime1));   // 100天前是2023-07-22 20:07:09
    }
}
