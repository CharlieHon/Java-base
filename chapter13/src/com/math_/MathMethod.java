package com.math_;

public class MathMethod {
    public static void main(String[] args) {
        // 常用的静态属性
        System.out.println("e: " + Math.E);
        System.out.println("PI: " + Math.PI);
        // 常用的静态方法
        // 1. abs：求绝对值
        System.out.println(Math.abs(-12));  // 12
        // 2. pow：求幂
        System.out.println(Math.pow(2, 4)); // 16.0
        // 3. ceil：向上取整，返回 >= 该参数的最小整数(->double)
        System.out.println(Math.ceil(-3.0001)); // -3.0
        // 4. floor：向下取整，返回 <= 该参数的最大整数(->double)
        System.out.println(Math.floor(-4.9999));   // -5.0
        // 5. round：四舍五入
        System.out.println(Math.round(5.51)); // 6
        // 6. sqrt：求开方
        System.out.println(Math.sqrt(9));   // 3.0
        // 7. random：求随机数，返回的是 [0, 1) 之间的一个随机小数
        System.out.println(Math.random());
        // 获取 [a, b] 之间的一个整数！
        // (int)(a + Math.random() * (b - a + 1))
        System.out.println((int)(2 + Math.random() * (7 - 2 + 1))); // 返回 [2, 7] 之间的一个随机整数
        // 8. max, min：返回两个数之间的最大值、最小值
        System.out.println(Math.max(10, 66));   // 66
        System.out.println(Math.min(10, 66));   // 10
    }
}
