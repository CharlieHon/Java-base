package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp04 {
    public static void main(String[] args) {
        String content = "hanshunping 韩 寒冷";
        String regStr = "han|韩|寒";  // 选择匹配符
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group());
        }
    }
}
