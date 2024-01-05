package com.charlie.regexp;

import java.util.regex.Pattern;

/**
 * 演示 matches方法，用于整体匹配，在验证输入的字符串是否满足条件时使用
 */
public class PatternMethod {
    public static void main(String[] args) {
        String content = "hello abc hello, world";
//        String regStr = "hello";  // false 只匹配到部分内容
        String regStr = "hello.*";  // true 整体匹配
        boolean matches = Pattern.matches(regStr, content);
        System.out.println("整体匹配：" + matches);
    }
}
