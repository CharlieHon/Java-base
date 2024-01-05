package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp12 {
    public static void main(String[] args) {
        String content = "Hello17 12315-777999111jack tom11, jack22 yyy666666 xx5225 leslie1551";

        // 匹配一个二位数，个十位数字相同
//        String regStr = "(\\d)\\1"; // 11 22 66 66 66
        // 匹配五个连续的相同数字：(\\d)\\1{4}
//        String regStr = "(\\d)\\1{4}";  // 66666
        // 匹配个位与千位相同，十位与百位相同的数，如 5225 1551 (\\d)(\\d)\\2\\1
//        String regStr = "(\\d)(\\d)\\2\\1"; // 6666 5225 1551

        /**
         * 在字符串中检索商品编号，形式如：12321-333999111 这样的号码。
         * 要求满足前面是一个五位数，然后一个-号，后面是一个九位数，连续的每三位要相同
         */
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0));
        }
    }
}
