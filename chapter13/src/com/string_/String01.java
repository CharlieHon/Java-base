package com.string_;

public class String01 {
    public static void main(String[] args) {
        // 1. String 对象用于保存字符串，也就是一组字符序列
        // 2. 字符串常量对象，用双引号括起来的字符序列
        // 3. 字符串的字符使用 Unicode 编码
        // 4. String 类有多个构造器
        String name = "Peter Pack";
        // 5. String类实现了接口 Serializable-[String 实现了串行化，可以在网络传播]
        //                      Comparable-[String 对象可以比较大小]
        // 6. String 是 final 类，不能被继承
        // 7. String 有属性 private final char value[]; 用于存放字符串内容
        // 8. value 是 final 类型，赋值后不可修改(地址不可修改，即value不能指向新的地址，但是单个字符内容是可以变化的)
        final char[] value = {'a', 'b', 'c'};
        char[] v2 = {'t', 'o', 'm'};
        value[0] = 'k';
//        value = v2; // 不可以修改，指的是 value 指向的地址不能改变
        System.out.println(value);  // kbc
    }
}
