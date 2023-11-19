package com.hspedu.reflection.class_;

import com.hspedu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 1. Class也是类，因此也继承Object类
        // 2. Class对象不是new出来的，而是系统创建的
        // (1) 传统new对象
        /* ClassLoader类
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */
//        Cat cat = new Cat();
        // (2) 反射方式，需要注销上行，同一个类只会加载一次
        /* ClassLoader类，仍然是通过ClassLoader类加载Cat类的Class对象
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */
        Class<?> cls = Class.forName("com.hspedu.Cat");

        // 3. 对于某个类的Class对象，在内存中只有一份，因为类只加载一次
        Class<?> cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls.hashCode()); // 460141958
        System.out.println(cls2.hashCode());    // 460141958    是同一个对象
        Class<?> cls3 = Class.forName("com.hspedu.Dog");
        System.out.println(cls3.hashCode()); // 1163157884 另一个对象

        // 4. 每个类的实例都会记得自己是由哪个Class实例所生成的
        // 5. 通过Class对象可以完整地得到一个类地完整结构，通过一系列API
        // 6. Class对象是存放在堆的
        // 7. 类的字节码二进制数据，是放在方法区的，有的地方成为元数据(包括方法代码，变量名，方法名，访问权限等)
    }
}
