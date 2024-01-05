package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp07 {
    public static void main(String[] args) {
        String content = "hanshunping s7789 nn1895han";

        // 非命名分组
        /*
        1. matcher.group(0) 得到匹配到的字符串
        1. matcher.group(1) 得到匹配到的字符串的第1个分组内容
        1. matcher.group(2) 得到匹配到的字符串的第2个分组内容
         */
        // String regStr = "(\\d\\d)(\\d\\d)"; // 匹配4个数字的字符串

        // 命名分组：即可以给分组取名
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)"; // 匹配4个数字的字符串

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
            System.out.println("第1个分组内容：" + matcher.group(1));
            System.out.println("通过组名取得内容：" + matcher.group("g1"));
            System.out.println("第2个分组内容：" + matcher.group(2));
            System.out.println("通过组名取得内容：" + matcher.group("g2"));
        }
    }
}
