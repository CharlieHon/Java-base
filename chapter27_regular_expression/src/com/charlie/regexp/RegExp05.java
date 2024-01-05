package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示限定符的使用
 */
public class RegExp05 {
    public static void main(String[] args) {
        String content = "a1111111aaaaaahello";
//        String regStr = "a{3}"; // 匹配 aaa
//        String regStr = "1{4}"; // 匹配 1111
//        String regStr = "\\d{2}";   // 表示匹配 两位的任意数字字符

        // java是贪婪匹配，即尽可能匹配多的
//        String regStr = "a{3,4}";   // 表示匹配 aaa 或 aaaa
//        String regStr = "\\d{2,5}";   // 表示匹配 2/3/4/5位数

//        String regStr = "1+";   // 表示匹配 1个或多个 1，默认仍然是贪婪匹配
        String regStr = "a1?";   // 表示匹配 a 或 a1

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
