package com.hspedu.classload_;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassLoad_ {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String key = scanner.next();
        switch (key) {
            case "1":
                // 因为 new Dog()时静态加载，所以必须编写Dog
                Dog dog = new Dog();    // 静态加载，依赖性很强，编译时就需要加载Dog类
                dog.cry();
                break;
            case "2":
                // 反射 -> 动态加载
                // 没有编写Person类也不会报错，只有当动态加载该类时，才会报错
                Class<?> cls = Class.forName("Person"); // 加载Dog类[动态加载]，在运行时才会加载Person类，
                Object o = cls.newInstance();
                Method cry = cls.getMethod("hi");
                cry.invoke(o);
                break;
            default:
                System.out.println("do nothing...");
        }
    }
}

class Dog {
    public void cry() {
        System.out.println("汪汪队出动~");
    }
}

class Person {
    public void hi() {
        System.out.println("小孩打招呼~");
    }
}