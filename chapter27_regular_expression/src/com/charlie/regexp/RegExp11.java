package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示正则表达式的使用
 */
public class RegExp11 {
    public static void main(String[] args) {
//        String content = "https://www.bilibili.com" +
//                "/video/BV1fh411y7R8/?p=894&spm_id_from=pageDriver";

        String content = "https://www.bilibili.com/video/BV1bW4y1P7MM/?spm_id_from=top_right_bar_window_dynamic.content.click&vd_source=e4a60aec69011298c6689621c8498cb6";

        /**
         * 思路
         * 1. 先确定url的开始部分 https:// 或 http://
         * 2. 然后通过 ([\\w]+\\.)+[\\w]+ 匹配 www.bilibili.com
         */
        // 注意：[.?*%#] 表示匹配的就是 .?* 等本身
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("格式匹配！");
//            System.out.println(matcher.group(0));
        } else {
            System.out.println("格式不匹配~");
        }
    }
}
