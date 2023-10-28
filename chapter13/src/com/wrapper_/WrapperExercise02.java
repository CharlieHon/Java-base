package com.wrapper_;

public class WrapperExercise02 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        /* 源码
        public static Integer valueOf(int i) {
            // 1. 如果传入 i 的范围在 [-128, 127] 时，就直接从缓存数组返回
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);  // 2. 不在范围则返回新建的对象
        }
         */
        Integer m = 1;  // Integer.valueOf(m)
        Integer n = 1;
        System.out.println(m == n); // true

        Integer x = 128;    // 不在 [-128, 127] 范围，new Integer()
        Integer y = 128;    // 创建新对象
        System.out.println(x == y); // false
    }
}
