package chapter03;

public class charDetail {
    public static void main(String[] args) {
        /** 字符类型(char)
         * 字符类型可以表示 单个字符 ，char是两个字节(可以存放汉字)，
         * 多个字符用字符串String
         */
        char c1 = 'a';
        char c2 = '\t';
        char c3 = '韩';
        char c4 = 65;
        System.out.println(c1); // a
        System.out.println(c2); // tab缩进
        System.out.println(c3); // 韩
        System.out.println(c4); // A

        /** 字符类型使用细节
         * 1.字符常量使用单引号('')括起来的单个字符
         * 2.Java允许使用转义字符'\'来将其后的字符转变为特殊字符型常量
         * 3.在Java中，char的本质是一个整数，在输出时，是unicode码对应的字符
         * 4.可以直接给char赋值一个整数，然后输出时，会被按照对应的unicode字符输出
         * 5.char类型是可以进行运算的，相当于一个整数，因为它们都有对应的unicode码
         */
        System.out.println((int)c1);    // 97
        System.out.println((int)c3);    // 38889
        System.out.println('a' + 10);   // 97 +10 => 107
        // 测试
        char c5 = 'b' + 1;  // 98 +1 = 99
        System.out.println(c5); // c
        
        /** 字符编码表
         * 1. ASCII：用一个字节表示，一共128个字符(实际上一个字节可以表示256个字符，只用了128个)
         * 2. Unicode：固定大小编码，使用两个字节来表示字符，字母和汉字统一都是占用两个字节
         * 3. utf-8：大小可变编码，字母使用1个字节，汉字使用3个字节
         * 4. gbk：可以表示汉字，而且范围广，字母使用1个字节，汉字2个字节
         * 5. gb2312：可以表示汉字，gb2312 < gbk
         * 6. big5码：繁体中文，台湾，香港
         */
    }
}
