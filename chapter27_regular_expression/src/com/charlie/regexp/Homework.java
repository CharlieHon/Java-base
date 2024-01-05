package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {
    public static void main(String[] args) {

        // 1. 验证电子邮件格式是否合法
//        String content = "2295509496@qq.com";
        String content = "jack@sohu.com.cn";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        // String 的 matcher 是整体匹配
        System.out.println(content.matches(regStr) ? "验证成功！" : "验证失败~");

        // 2. 验证是不是整数或者小数，提示：需要考虑正数和负数
        String[] contents = {"+123", "-345", "0.16", "00.36", "34.89", "-87.9", "-0.01", "0.45", "3.", ".35", "0.0"};
        for (String s : contents) {
            regStr = "^[+-]?([1-9]\\d*|0)(\\.\\d+)?$";
            boolean matches = Pattern.matches(regStr, s);
            System.out.println(s + " " + (matches ? "验证成功！" : "验证失败~"));
        }

        // 3. 对一个url进行解析
        String url = "http://www.sohu.com:8080/servlet/abc/index.html";
        // 正则表达式是根据要求来编写的，如果需要的话，可以改进
        regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            System.out.println("url：匹配成功");
            System.out.println("整体匹配：" + matcher.group(0));
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(3));
            System.out.println("文件：" + matcher.group(4));
            /*
            整体匹配：http://www.sohu.com:8080/abc/index.html
            协议：http
            域名：www.sohu.com
            端口：8080
            文件：index.html
             */
        } else {
            System.out.println("url：匹配失败");
        }
    }
}
