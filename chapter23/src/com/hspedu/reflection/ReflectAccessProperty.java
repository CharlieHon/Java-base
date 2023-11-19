package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * 演示反射访问属性操作
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 1. 得到Student类对应的Class对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        // 2. 创建对象
        Object o = stuClass.newInstance();
        System.out.println(o.getClass());   // class com.hspedu.reflection.Student
        // 3. 使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o, 21);
        System.out.println(o);  // Student{age=21,name=null}
        System.out.println(age.get(o));
        // 4.使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        // 对name进行爆破，才可以操作private属性
        name.setAccessible(true);
        name.set(o, "李自成");
        // 对于 static 属性，可以使用 name.set(null, "hsp");
        System.out.println(o);  // Student{age=21,name=李自成}
        System.out.println(name.get(o));    // 李自成
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ",name=" + name +
                '}';
    }
}