package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp13 {
    public static void main(String[] args) {
        String content = "我...我要...学学学学...编程java";
        // 1. 去掉所有的.
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
//        System.out.println(content);    // 我我要学学学学编程java

        // 2. 去掉重复的字
        /*
        思路
        1) 使用 (.)\\1+ 匹配连续出现的任意字符
        2) 使用 反向引用$1
         */
//        pattern = Pattern.compile("(.)\\1+");
//        matcher = pattern.matcher(content);
//        while (matcher.find()) {
//            System.out.println(matcher.group(0)); // 我我 学学学学
//        }
//        // 使用反向引用$1 替换匹配到的内容
//        content = matcher.replaceAll("$1");
//        System.out.println(content);

        // 3. 使用一条语句，去掉重复的字
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
