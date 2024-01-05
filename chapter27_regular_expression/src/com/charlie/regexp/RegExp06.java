package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示定位符的使用
 */
public class RegExp06 {
    public static void main(String[] args) {
//        String content = "123abc";
        String content = "hanshunping sphan nnhan";
//        String regStr = "^[0-9]+[a-z]*";    // 以至少1个数字开头，后接任意个小写字母的字符串
//        String regStr = "^[0-9]+[a-z]+$";    // 以至少1个数字开头，必须以1小写字母结束

//        String regStr = "han\\b";    // 表示匹配右边界的han，边界可以是字符串最后，也可以是空格分隔的子串
        String regStr = "han\\B";    // 表示匹配左边界的han，边界可以是字符串最后，也可以是空格分隔的子串

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
