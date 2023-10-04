package chapter03;

public class DataType {
    // 1.Java数据类型分为两大类：基本数据类型，引用类型
    // 2.基本数据类型有8种：数值型[byte[1], short[2], int[4], long[8]]
    // float[4], double[8], char[2], boolean[1]
    // 3.引用类型：[类，接口，数组]
    public static void main(String[] args) {
        /** 基本数据类型转换
         * 当java程序在进行赋值或者运算时，精度小的类型自动转换为精度大的数据类型
         * 数据类型按精度(容量)大小排序为
         * char -> int -> long -> float -> double
         * byte -> short -> int -> long -> float -> double
         */
        int a = 'c';
        double b = 80;
        System.out.println(a);  // 99
        System.out.println(b);  // 80.0

        /** 自动类型转换的细节
         * 1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型
         *      然后再进行计算
         * 2. 当把精度(容量)大的数据类型赋值给精度(容量)小的数据类型时，
         *      就会报错，反之就会进行自动类型转换
         * 3. (byte, short) 和 char 之间不会相互自动转换
         * 4. byte, short, char 三者可以计算，在计算时首先转换为int类型。
         * 5. boolean不参与转换
         * 6. 自动提升原则：表达式结果的类型自动提升为 操作数中最大的类型
         */
        int n1 = 10;
        // float f1 = n1 + 1.1;    // 错误：n1 + 1.1 结果类型是 double
        double d1 = n1 + 1.1;
        float f2 = n1 + 1.1F;

        // int n2 = 1.1;   // 错误：double转换成int，精度缺失，错误
        // ！(1)当把数据赋给byte时，先判断该数是否在byte范围内，如果是就可以
        byte b1 = 10;   // -128~127
        int n2 = 1;
        // byte b2 = n2;   // (2)如果是变量赋值，先判断类型。错误：int类型不能转换为byte
        // char c1 = b1;   // 错误：byte不能自动转成char [3]

        byte b2 = 1;
        short s1 = 1;
        // short s2 = b2 + s1; // 错误：b2 + s1 => int [4]
        int n3 = b2 + s1;
        System.out.println(n3); // 2
        // byte b3 = b1 + b2;  // 错误：只要运算中出现(byte,char,short)，运算结果都是int [4]

        boolean pass = true;
        // int num1 = pass; // 错误：boolean类型不参与类型的字段转换 [5]

        // [6]
        byte b4 = 1;
        short s2 = 100;
        int num2 = 1;
        double d2 = 1.1;
        double res = b4 + s2 + num2 + d2;   // 运算结果是 double 类型
        System.out.println(res);    // 103.1
    }
}
