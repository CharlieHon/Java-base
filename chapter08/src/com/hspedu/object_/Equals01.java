package com.hspedu.object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        // ==：对于引用类型，判断的是不是同一个对象
        System.out.println(a == c); // true
        System.out.println(b == c); // true

        B obj = a;  // 虽然编译类型不同，但是指向的内存地址相同
        System.out.println(obj == a);   // true

        // ==：对于基本类型，判断的是值是否相等
        int num1 = 10;
        double num2 = 10.0;
        System.out.println(num1 == num2);   // true

        // 查看实现/原码：ctrl + b
        // equals()只能判断引用类型，默认判断的是地址是否相等
        "Hello".equals("hello");
/*
    public boolean equals(Object anObject) {
        if (this == anObject) { // 如果是同一个对象(地址相同)
            return true;        // 返回 true
        }
        if (anObject instanceof String) {   // 判断类型
            String anotherString = (String)anObject;    // 向下转型
            int n = value.length;
            if (n == anotherString.value.length) {  // 如果长度相同
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {  // 一个一个比较字符
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;    // 如果两个字符串的所有字符都相等，则返回true
            }
        }
        return false;
    }
 */
        Integer i = new Integer(100);
        Integer i1 = new Integer(100);
        System.out.println(i == i1);    // false    引用类型，判断的是否为同一对象
        System.out.println(i.equals(i1));   // true 重写equals方法，先判断是否为同一类型，再判断值是否相等
        System.out.println(i.equals(100.));   // false 类型不同，直接返回false

        String str1 = new String("Charlie");
        String str2 = new String("Charlie");
        System.out.println(str1 == str2);   // 引用类型，判断地址不同，返回 false
        System.out.println(str1.equals(str2));  // true 值相同
    }
}

class B extends Object {}
class A extends B {}