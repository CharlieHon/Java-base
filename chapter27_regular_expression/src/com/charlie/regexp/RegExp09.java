package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示非贪婪匹配
 */
public class RegExp09 {
    public static void main(String[] args) {
        String content = "hello119527 ok";
//        String regStr = "\\d+"; // 默认贪婪匹配
        String regStr = "\\d+?"; // 在限定符后加上一个? 表示非贪婪匹配，尽可能少的匹配字符

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
