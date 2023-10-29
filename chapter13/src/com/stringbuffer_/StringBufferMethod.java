package com.stringbuffer_;

public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        // 增
        s.append(',');
        s.append("张三丰");
        s.append("太极").append(100).append(true).append(10.5);
        System.out.println(s);  // hello,张三丰太极100true10.5
        // 删
        s.delete(11, 14);   // 删除 [11, 14) 索引处字符
        System.out.println(s);  // hello,张三丰太极true10.5
        // 改
        s.replace(9, 11, "无极"); // 将 [9, 11) 索引处字符替换为 无极
        System.out.println(s);  // hello,张三丰无极true10.5
        // 查
        int index = s.indexOf("张三丰");
        System.out.println(index);  // 6
        // 插
        s.insert(9, "张无忌"); // 在索引为9的位置插入 "张无忌"，原来索引为9的内容自动后移
        System.out.println(s);
        // 长度
        System.out.println(s.length()); // 22
    }
}
