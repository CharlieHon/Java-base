package com.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str); // 底层调用的是 AbstractStringBuilder 的 appendNull() 方法，把 "null" 字符串拼进去
        System.out.println(sb.length());    // 4
        System.out.println(sb); // null

        StringBuffer sb1 = new StringBuffer(str);   // 执行 super(str.length() + 16) 报错：NullPointerException
        System.out.println(sb1);
    }
}
