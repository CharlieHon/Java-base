package com.hspedu.reflection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

/**
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.hspedu.Car";
        // 1. 获取到Car类，对应的Class对象
        // <?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        // 2. 输出cls
        System.out.println(cls);    // 显示cls对象，是哪个类的Class对象 class com.hspedu.Car
        System.out.println(cls.getClass()); // 输出cls的运行类型 java.lang.Class
        // 3. 得到包名
        System.out.println(cls.getPackage().getName()); // com.hspedu
        // 4. 全类名
        System.out.println(cls.getName());  // com.hspedu.Car
        // 5. 通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);    // Car{brand='BMW', price=50, color='white'}
        // 6. 通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car)); // BMW
        // 7. 通过反射给属性赋值
        brand.set(car, "五菱宏光");
        System.out.println(brand.get(car)); // 五菱宏光
        // 8. 得到所有的属性
        Field[] fields = cls.getFields();
        for(Field f : fields) {
            System.out.println(f.getName());    // brand price color
        }
    }
}
