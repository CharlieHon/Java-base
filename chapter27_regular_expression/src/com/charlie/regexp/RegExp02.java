package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp02 {
    public static void main(String[] args) {
        String content = "abc$(abcd(123(";
        // 匹配 ( => \\(
        // 匹配 . => \\.
//        String regStr = "\\(";
        String regStr = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
