package com.hspedu.reflection.question;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射问题的引入
 */
public class ReflectionQuestion {
    // 根据配置文件 re.properties 指定信息，创建Cat对象并调用方法hi
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 传统方式 new对象 -> 调用方法
//        Cat cat = new Cat();
//        cat.hi(); ===> cat.cry(); 需要修改源码

        // 1. 使用 Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
//        System.out.println("classfullpath=" + classfullpath);   // classfullpath=com.hspedu.Cat
//        System.out.println("methodName=" + methodName); // methodName=hi
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
    }
}
