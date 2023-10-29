package com.stringbuilder_;

public class StringBuilder01 {
    public static void main(String[] args) {
        // 1. StringBuilder 继承了 AbstractStringBuilder 类
        // 2. 实现了 Serializable，说明 StringBuilder 对象是串行化的(对象可以网络传入，可以保存到文件)
        // 3. 是 final 类，不能被继承
        // 4. StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder 的 char[] value
        //      所以字符序列是在 堆 中
        // 5. StringBuilder 的方法，没有做互斥处理，即没有 synchronized 关键字，因此在单线程的情况下使用
        StringBuilder stringBuilder = new StringBuilder();
    }
}
