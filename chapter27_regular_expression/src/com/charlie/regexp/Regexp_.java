package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式对文本处理的帮助
 */
public class Regexp_ {
    public static void main(String[] args) {
        // 假定使用爬虫从百度页面得到如下的文本
        String content = "Java是一门面向对象的高级编程语言，不仅吸收了C语言的各种优点，还摒弃了C里难以理解的多继承、指针等概念，" +
                "因此Java语言具有功能强大和简单易用两个特征。2024-01-05。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，" +
                "允许程序员以优雅的思维方式进行复杂的编程。Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与" +
                "可移植性、多线程、动态性等特点。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等。";
        // - 提取文章中所有的英文单词
        // 1. 传统方法，使用遍历方式，代码量大且效率不高
        // 2. 正则表达式方法

        // 1) 先创建一个Pattern对象，模式对象，可以理解成就是一个正则表达式对象
//        Pattern pattern = Pattern.compile("[a-zA-z]+");     // - 提取文章中所有的英文单词
//        Pattern pattern = Pattern.compile("[0-9]+");     // - 提取文章中所有的数字
        Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");     // - 提取文章中所有的数字和英文单词

        // 2) 创建一个匹配其对象
        // 理解：matcher 匹配器按照 pattern(模式/样式) 到 content 文本中去匹配
        // 找到就返回 true，否则就返回false
        Matcher matcher = pattern.matcher(content);
        // 3) 可以开始循环匹配
        while (matcher.find()) {
            // 匹配内容/文本，放在 m.group(0)
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
