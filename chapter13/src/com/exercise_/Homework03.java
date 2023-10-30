package com.exercise_;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Han Shun Ping";
//        String name = "Willian Jefferson Clinton";
        System.out.println(name);
        System.out.println("===转换后===");
//        System.out.println(test(name));
        printName(name);
    }

    public static void printName(String name) {
        /*
        编写java程序，输入形式为：Han shun Ping的人名，以 Ping,Han.S 的形式打印出来。
        其中 .S 是中间单词的首字母大写
        思路分析：
        1. 对输入的字符串进行分隔 split("")
        2. 对得到的 String[] 进行格式化 String.format()
        3. 对输入的字符串进行校验
         */
        if (name == null) {
            System.out.println("字符串不能为空");
            return;
        }
        String[] names = name.split(" ");
        if (names.length != 3) {
            System.out.println("输入字符出格式有误");
            return;
        }
        String format = String.format("%s,%s.%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }

    public static String test(String name) {
        if (name == null) {
            throw new RuntimeException("姓名不能为空");
        }
        char[] src = name.toCharArray();

        int i = name.indexOf(' ');
        int j = name.lastIndexOf(' ');
        int len1 = i, len2 = j - i - 1, len3 = src.length - j - 1;
//        char[] dest = new char[src.length];
        char[] dest = new char[len1 + len3 + 3]; // len1 + len3 + 3
        System.arraycopy(src, j + 1, dest, 0, len3);    // Ping
        System.arraycopy(src, 0, dest, len3 + 1, len1);    // Han
//        System.arraycopy(src, i + 1, dest, j + 1, len2);    // Shun
        System.arraycopy(src, i + 1, dest, len3 + len1 + 2, 1);    // Shun
        dest[len3] = ',';
        dest[len3 + len1 + 1] = '.';
        dest[dest.length - 1] = Character.toUpperCase(dest[dest.length - 1]);
        return new String(dest);
    }
}
