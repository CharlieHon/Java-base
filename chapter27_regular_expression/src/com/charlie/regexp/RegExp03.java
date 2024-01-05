package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符匹配符的使用
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content = "a11C8abc $ABCy_ &";
//        String regStr = "[a-z]";    // 匹配 a-z 之间任意一个字符
//        String regStr = "[A-Z]";    // 匹配 A-Z 之间任意一个字符
//        String regStr = "abc";    // 匹配 abc 字符串，默认区分大小写
//        String regStr = "(?i)abc";    // 匹配 abc 字符串，不区分大小写
//        String regStr = "[^a-z]";   // 表示匹配不是a-z中的任意一个字符
//        String regStr = "[abcd]";   // 表示匹配 abcd 中的任意一个字符
//        String regStr = "\\w";   // 表示匹配 数字 英文字符 下划线
//        String regStr = "\\s";   // 表示匹配 任意空白字符
        String regStr = "\\S";   // 与 \\s 相反

        // 当创建 Pattern对象时，指定 Pattern.CASE_INSENSITIVE 表示匹配是不区分字母大小写的
        Pattern pattern = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
