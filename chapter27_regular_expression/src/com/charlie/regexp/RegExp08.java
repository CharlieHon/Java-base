package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示非捕获分组，语法比较奇怪
 */
public class RegExp08 {
    public static void main(String[] args) {
        String content = "韩顺平 韩顺平你好 hello韩顺平教育 韩顺平老师jack 韩顺平同学js";

//        String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
        // 上面的写法可以等价的非捕获分组
//        String regStr = "韩顺平(?:教育|老师|同学)";  // 韩顺平教育 韩顺平老师 韩顺平同学
//        String regStr = "韩顺平(?=教育|老师)";  // 只匹配 韩顺平教育或韩顺平老师 中的 韩顺平
        String regStr = "韩顺平(?!教育|老师)";  // 找到 韩顺平 这个关键字，但是要求不是 韩顺平教育和韩顺平老师 中包含有的韩顺平

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
