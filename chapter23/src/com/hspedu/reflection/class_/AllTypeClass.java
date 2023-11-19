package com.hspedu.reflection.class_;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;  // 外部类
        Class<Thread.State> cls2 = Thread.State.class;  // 枚举
        Class<Long> cls3 = long.class;  // 基本数据类型
        Class<Void> cls4 = void.class;  // void
        Class<Integer> cls5 = Integer.class;    // 包装类
        Class<Class> cls6 = Class.class;    // Class类
        Class<Serializable> cls7 = Serializable.class;  // 接口
        Class<int[]> cls8 = int[].class;    // 数组
        Class<Deprecated> cls9 = Deprecated.class;  // 注解
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
