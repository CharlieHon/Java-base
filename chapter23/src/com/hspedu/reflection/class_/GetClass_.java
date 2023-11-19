package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * 演示得到Class对象的各种方式(6)
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. Class.forName()
        String classAllPath = "com.hspedu.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);   // class com.hspedu.Car

        // 2. 类名.class，应用场景：多用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);   // class com.hspedu.Car

        // 3. 对象.getClass() 应用场景，有对象实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);   // class com.hspedu.Car

        // 4. 通过类加载器【4种】来获取类对象
        // (1) 先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2) 通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);   // class com.hspedu.Car

        // 5. 基本数据类型(int, char, boolean, float, double, byte, long, short)
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        System.out.println(integerClass);   // int

        // 6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class独享
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type1);   // char
    }
}
