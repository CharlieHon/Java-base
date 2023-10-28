package com.string_;

public class StringMethod02 {
    public static void main(String[] args) {
        // 1. toUpperCase：转成大写
        String s = "Hello";
        System.out.println(s.toUpperCase());    // HELLO
        // 2. toLowerCase：装成小写
        System.out.println(s.toLowerCase());    // hello
        // 3. concat：拼接字符串
        String s1 = "木石";
        s1 = s1.concat("前盟").concat("阆苑仙葩").concat("美玉无瑕");
        System.out.println(s1); // 木石前盟阆苑仙葩美玉无瑕
        // 4. replace(oldChar, replacement)：替换字符串中的字符
        String s2 = "世人都晓神仙好，惟有功名忘不了！";
        s2 = s2.replace("功名", "金银");    // s1.replace()执行后，返回的结果才是替换过的，原对象无变化
        System.out.println(s2); // 世人都晓神仙好，惟有金银忘不了！
        // 5. split：分隔字符串，对于某些分隔字符，需要进行转义
        String poem = "安得广厦千万间，大庇天下寒士俱欢颜，风雨不动安如山";
        String[] split = poem.split("，");   // 以"，"为标准对 poem 进行分隔
        for (String str :
                split) {
            System.out.println(str);
        }
        String path = "E:\\aaa\\bbb";
        split = path.split("\\\\");
        for (String str :
                split) {
            System.out.println(str);    // E:   aaa bbb
        }
        // 6. toCharArray：转换成字符数组
        s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.print(chs[i] + " "); // h a p p y
        }
        System.out.println("");
        // 7. compareTo：比较两个字符串的大小，如果前者大，则返回正数，后者大，则返回负数，相等则返回0
        String a = "json";
        String b = "john";
        String c = "johnson";
        /*
        逐个比较字符，遇到不相同(如下标i)的则返回前一个对象的字符减去后一个对象的字符并返回该值，即 a.charAt(i) - b.charAt(i)
        如果前面部分都相同，则返回 a.length - b.length
         */
        System.out.println(a.compareTo(b)); // 返回值是 's' - 'o' = 4
        System.out.println(b.compareTo(c)); // 返回值是 b.length - c.length = -3
        // 8. format：格式化字符串
        // 1. %s %d %.2f %c 称为占位符
        // 2. 这些占位符由后面变量来替换
        // 3. %s：表示字符串；%d：表示正数；%c：表示字符；%.2f：表示浮点数，保留小数点后两位(四舍五入)
        String name = "张三";
        int age = 25;
        char gender = '男';
        double score = 278.5 / 3;
        String formatStr = "姓名：%s，性别：%c，年龄：%d，分数：%.2f";
        String info = String.format(formatStr, name, gender, age, score);
        System.out.println(info);   // 姓名：张三，性别：男，年龄：25，分数：92.83
    }
}
