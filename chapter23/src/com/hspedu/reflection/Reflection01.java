package com.hspedu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
        // 1. 使用 Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        // 2. 创建对象，传统方法行不通 -> 反射机制
//        new classfullpath();
        // 3. 使用反射机制解决
        // (1) 加载类，返回Class类型的对象
        Class<?> cls = Class.forName(classfullpath);
        // (2) 通过 cls对象得到加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());   // 运行类型 class com.hspedu.Cat
        // (3) 通过 cls 得到加载的类 com.hspedu.Cat 的 methodName 的方法对象
        //      即：再反射中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        // (4) 通过method1调用方法，即通过方法对象来实现对象方法
        System.out.println("===========");
        method1.invoke(o);  // 传统方法：对象.方法()；反射机制：方法.invoke(对象)

        // java.lang.reflect.Field：代表类的成员变量，Field对象标识某个类的成员变量
        Field ageField = cls.getField("age");  // getField不能得到私有字段
        System.out.println(ageField.get(o));    // 传统写法：对象.成员变量；反射：成员变量.get(对象) 2

        // java.lang.reflect.Constructor：代表类的构造方法，Constructor对象标识构造器
        Constructor<?> constructor = cls.getConstructor();  // ()中可以指定构造器参数类型
        System.out.println(constructor);    // public com.hspedu.Cat()

        Constructor<?> constructor1 = cls.getConstructor(String.class); // 传入的 String.class 就是String的Class类对象
        System.out.println(constructor1);   // public com.hspedu.Cat(java.lang.String)
    }
}
