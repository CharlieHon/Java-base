package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu charlie haha~ hello Monkey.D.Luff";
        String regStr = "hello";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("==================");
            // 返回匹配到的起止索引
            System.out.println(matcher.start() + ": " + matcher.end());
            System.out.println("匹配到：" + content.substring(matcher.start(), matcher.end()));
//            System.out.println("匹配到：" + matcher.group(0));
        }

        // 整体匹配方法，常用于检验某个字符串是否满足某个规则
        System.out.println("整体匹配：" + matcher.matches());

        // 如果有charlie，就替换为bruce
        regStr = "charlie";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        // 注意：返回的字符串才是替换后的字符串
        String newContent = matcher.replaceAll("bruce");
        System.out.println("替换结果：" + newContent);   // hello edu bruce haha~ hello Monkey.D.Luff
    }
}
