package com.hspedu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 演示通过反射机制创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // 1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.hspedu.reflection.User");
        // 2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);  // User{age=10, name='Kiki'}

        // 3. 通过public的有参构造器创建实例
        /*
        constructor 对象是
        public User(String name) {
            this.name = name;
        }
         */
        // 3.1 先得到对应的构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        // 3.2 再创建实例，并传入实参
        Object o1 = constructor.newInstance("hsp");
        System.out.println(o1); // User{age=10, name='hsp'}

        // 4. 通过非public的有参构造器创建实例
        // 4.1 先得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        // 4.2 再创建实例
        // 爆破【暴力破解】，使用反射器可以访问private构造器，反射面前都是纸老虎。不设置会报错！
        constructor1.setAccessible(true);
        Object o2 = constructor1.newInstance(21, "Charlie");
        System.out.println(o2);
    }
}

class User {
    private int age = 10;
    private String name = "Kiki";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}