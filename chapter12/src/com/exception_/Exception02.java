package com.exception_;

public class Exception02 {
    public static void main(String[] args) {
        // 1. NullPointerException
        String name = "张三";
//        String name1 = null;
        System.out.println(name.length());  // name1.length()
        // 2. ArithmeticException
//        System.out.println(1/ 0);
        // 3. ArrayIndexOutOfBoundsException
        int[] arr = {1, 8, 9, 5};
//        System.out.println(arr[4]);
        // 4. ClassCastException
        B a = new B();  // 向上转型
        B b = a;    // 向下转型
//        C c = (C)a; // 错误
        // 5. NumberFormatException
        String str = "1234";
        String str1 = "12a";
        int num = Integer.parseInt(str);
        System.out.println(num);    // 1234
//        int num1 = Integer.parseInt(str1);  // NumberFormatException
    }
}

class A {}
class B extends A {}
class C extends A {}