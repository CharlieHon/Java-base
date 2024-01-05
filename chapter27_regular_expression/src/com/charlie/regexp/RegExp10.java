package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp10 {
    public static void main(String[] args) {
        // 汉字
        String content = "不断的增长";
        // 邮政编码
//        String content = "155367";
        // QQ号码
//        String content = "2295509496";
        // 手机号
//        String content = "15825563227";


        // 1. 汉字
        // 汉字的unicode编码范围是 \u0391到\uffe5
//        String regStr = "^[\u0391-\uffe5]+$";
        // 2. 邮政编码
//        String regStr = "^[1-9]\\d{5}$";   // 以1-9开头的一个六位数
        // 3. QQ号码
//        String regStr = "^[1-9]\\d{4,9}$";   // 以1-9开头的一个六位数
        // 4. 手机号码
//        String regStr = "^(?:13|14|15|18)\\d{9}$";   // 必须以 13,14,15,18 开头的11位数
        String regStr = "^1[3|4|5|8]\\d{9}$";   // 必须以 13,14,15,18 开头的11位数

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
