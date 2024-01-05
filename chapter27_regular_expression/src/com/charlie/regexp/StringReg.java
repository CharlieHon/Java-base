package com.charlie.regexp;

public class StringReg {
    public static void main(String[] args) {
        String content = "附加额外开发和你就问吧v我就分解为开发那我就服你JDK1.3dwjdji还无法金额分别为JDK1.4复活节二百万厚积薄发JDK1.4dwjkdno";

        // 使用正则表达式，将JDK1.3和JDK1.4替换为JDK
        content = content.replaceAll("JDK1\\.[3-4]", "JDK");
        System.out.println(content);

        // 验证一个手机号，要求必须是以 139 139开头
        content = "13688889999";
        System.out.println(content.matches("13(6|8)\\d{8}") ? "验证成功！" : "验证失败~");

        // 分隔功能：要求按照#或者-或者~或者数字来分割
        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
