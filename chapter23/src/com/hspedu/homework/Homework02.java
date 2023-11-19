package com.hspedu.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 利用Class类的forName方法得到File类的Class对象
 * 在控制台打印File类的所有构造器
 * 通过newInstance的方法创建File对象，并创建e:/mynew.txt文件
 */
public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("java.io.File");
        for (Method declaredMethod : cls.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }
        // 通过带参数构造器创建对象
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o = constructor.newInstance("e:/mynew.txt");
        // 获取方法
        Method createNewFile = cls.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
