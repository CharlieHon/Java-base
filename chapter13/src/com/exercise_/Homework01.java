package com.exercise_;

public class Homework01 {
    public static void main(String[] args) {
        // 1. 将字符串中指定部分进行反转。比如将 "a bcde f" -> "a edcb f
        String str = "abcdef";
        System.out.println(str);
        boolean flag = true;
        try {
            str = reverse(str, 1, 3);
        } catch (Exception e) {
            flag = false;
            System.out.println(e.getMessage());
        } finally {
            if (flag) {
                System.out.println("===反转后===");
            } else {
                System.out.println("格式有误，未进行反转");
            }
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {
        if (str == null) {
            throw new NullPointerException("字符串不能为空");
        }
        int len = str.length();
        if (start < 0 || end > len - 1) {
            throw new RuntimeException("索引超出字符串范围");
        }
        if (end < start) {
            throw new RuntimeException("区间有无");
        }
        if (start == end) {
            return str;
        }

        char[] value = str.toCharArray();
        char tmp = '\0';
        for (int i = start, j = end; i <= j; ++i, --j) {
            if (i != j) {
                tmp = str.charAt(i);
                value[i] = str.charAt(j);
                value[j] = tmp;
            } else {
                value[i] = str.charAt(i);
            }
        }
        return new String(value);

//        char[] value = new char[str.length()];
//        int index = 0;
//        while (index < start) {
//            value[index] = str.charAt(index);
//            ++index;
//        }
//        for (int i = start, j = end; i <= j; ++i, --j) {
//            if (i != j) {
//                char tmp = str.charAt(i);
//                value[i] = str.charAt(j);
//                value[j] = tmp;
//            } else {
//                value[i] = str.charAt(i);
//            }
//        }
//        index = end + 1;
//        while (index < str.length()) {
//            value[index] = str.charAt(index);
//            ++index;
//        }
//        return new String(value);


//        StringBuffer sb = new StringBuffer();
//        sb.append(str, 0, start);
//        for (int i = end; i >= start; i--) {
//            sb.append(str.charAt(i));
//        }
//        sb.append(str, end + 1, str.length());
//        return sb.toString();
    }
}
