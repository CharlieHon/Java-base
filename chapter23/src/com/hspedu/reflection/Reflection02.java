package com.hspedu.reflection;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 测试反射调用的性能，和优化方案
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        // Field, Method, Constructor都继承了AccessibleObject类进行检测
        m1();   // 传统方法调用hi 耗时=3
        m2();   // 反射方法调用hi 耗时=728
        m3();   // 反射优化调用hi 耗时=532
    }
    // 传统方法来调用hi
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法调用hi 耗时=" + (end - start));
    }
    // 反射机制调用hi方法
    public static void m2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        // 反射
        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method1 = cls.getMethod(method);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            method1.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方法调用hi 耗时=" + (end - start));
    }

    // 反射调用优化 - 关闭访问检测
    public static void m3() throws Exception {
        // 反射
        Class<?> cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);    // 设置为true表示，在反射调用方法时，取消访问检测
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射优化调用hi 耗时=" + (end - start));
    }
}
