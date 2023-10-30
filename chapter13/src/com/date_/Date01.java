package com.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        // 1. 获取当前系统时间
        // 2. 这里的 Date 类是在 java.util.Date
        // 3. 默认输出的日期格式是国外的方式，因此通常需要对格式进行转换
        Date d1 = new Date();
        System.out.println("当前日期：" + d1);   // 当前日期：Mon Oct 30 19:12:04 CST 2023

        Date d2 = new Date(9234567);    // 通过指定毫秒数获得时间
        System.out.println("d2=" + d2);

        // 1. 创建 SimpleDateFormat 对象，指定相应的格式
        // 2. 这里的格式使用的字母是规定好的，不能随意使用
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1); // format：将日期转换成指定格式的字符串
        System.out.println(format); // 2023年10月30日 07:16:00 星期一

        // 1. 可以把一个格式化的 String 转成对应的 Date
        // 2. 得到的 Date 输出时仍然按照的是 国外的形式，指定格式输出需要转换
        // 3. String -> Date 使用的 sdf 格式需要和给定的 String 格式一样，否则会抛出转换异常
        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);  // 此处需要显式处理异常
        System.out.println(parse);  // Mon Jan 01 10:20:30 CST 1996
    }
}
