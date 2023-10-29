package com.stringbuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        // 1. StringBuffer 的直接父类是 AbstractStringBuilder
        // 2. StringBuffer 实现了 Serializable，即StringBuffer的对象可以串行化
        // 3. 在父类 AbstractStringBuilder 中，有属性 char[] value，不是final
        //  该 value 数组存放 字符串内容，引用存放在堆中
        // 4. StringBuffer 是一个 final 类，不可以继承
        // 5. StringBuffer 字符内容存放在 char[] value，所以在变化(增加/删除)时
        //      不是每次都更新地址(即不是每次都创建对象)，所以效率高于 String
        StringBuffer stringBuffer = new StringBuffer();
    }
}
