package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {
    public static void main(String[] args) {

        // 1. 验证电子邮件格式是否合法
//        String content = "2295509496@qq.com";
        String content = "jack@sohu.com.cn";
        String regStr = "\\w+@([a-zA-Z]+\\.)+[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.matches() ? "验证成功！" : "验证失败~");

        // 2. 验证是不是整数或者小数
    }
}
