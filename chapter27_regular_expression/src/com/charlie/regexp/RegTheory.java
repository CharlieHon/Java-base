package com.charlie.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分析java的正则表达式底层实现
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了" +
                "第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型" +
                "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的" +
                "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应" +
                "用3443于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个" +
                "里程碑，标志着Java的应用开始普及9889 ";
        // 目标：匹配所有四个数字
        // 1. \\d 表示一个任意的数字(0-9)
        String regStr = "(\\d\\d)(\\d\\d)";
        // 2. 创建模式对象，即正则表达式对象
        Pattern pattern = Pattern.compile(regStr);
        // 3. 创建匹配器
        // 创建匹配器 matcher，按照正则表达式规则去匹配content字符串
        Matcher matcher = pattern.matcher(content);
        // 4. 开始匹配
        /**
         * matcher.find() 完成的工作
         * 1) 根据指定的规则 pattern ，定位满足规则的子字符串(比如1998)
         * 2) 找到后，将子字符串的开始索引记录到 matcher对象的属性 int[] groups;
         *  groups[0] = 0; 把该字符串的结果的索引+1的值记录到 group[1] = 4;
         * 3) 同时记录 oldLast 的值为 子字符串的结束的 索引+1的值即4，即下次执行 find是，就从4开始匹配
         * 4) matcher.group(0)
         *     public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *     1. 根据 groups[0]=0 和 groups[1]=4 的记录的位置，从content开始截取子字符串并返回
         *          就是 [0, 4) 包含0但是不包含索引为4的位置
         * 5) 如果再次执行 find() 方法，仍然按照上面分析来执行
         *
         *
         * 分组情况：当正则表达式中有小括号()时，比如 (\d\d)(\d\d)，第1个()表示第1组，第2个()表示第2组
         * 1) 根据指定的规则 pattern ，定位满足规则的子字符串，比如 (19)(98)
         * 2) 找到后，将子字符串的开始索引记录到 matcher对象的属性 int[] groups;
         *      2.1) groups[0] = 0，把该字符串的 结束的索引+1 的值记录到 groups[1] = 4;
         *      2.2) 把记录第1组()匹配到的字符串 groups[2] = 0, groups[3] = 2;
         *      2.3) 把记录第2组()匹配到的字符串 groups[4] = 2, groups[4] = 4;
         *      2.4) 如果有更多的分组，继续匹配
         * 3) 同时记录 oldLast 的值为 子字符串的结束的 索引+1的值即4，即下次执行 find是，就从4开始匹配
         * 4) matcher.group(0)
         */
        while (matcher.find()) {
            System.out.println("匹配到：" + matcher.group(0) + " "
                            + matcher.group(1) + " " + matcher.group(2));
            /*
            1. 如果正则表达式有 () 即分组
            2. 取出匹配的字符串规则如下
            3. group(0) 表示匹配到的子字符串
            4. group(1) 表示匹配到的子字符串的第1组子串
            5. group(2) 表示匹配到的子字符串的第2组子串
            6. 但是分组的数不能越界
            匹配到：1998 19 98
            匹配到：1999 19 99
            匹配到：3443 34 43
            匹配到：9889 98 89
             */
        }
    }
}
