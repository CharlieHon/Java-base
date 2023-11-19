package com.hspedu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 演示通过反射调用方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1.得到Boss类对应的Class对象
        Class<?> bossCls = Class.forName("com.hspedu.reflection.Boss");
        // 2. 创建对象
        Object o = bossCls.newInstance();
        // 3. 调用public的hi方法
        Method hi = bossCls.getMethod("hi", String.class);  // 带参方法必须，加上参数类型对应的Class对象
        Method hi1 = bossCls.getDeclaredMethod("hi", String.class); // 可以获取本类的所有方法
        hi.invoke(o, "kiki");
        hi1.invoke(o, "kiki");

        // 4. 获取private static方法
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        // 因为say方法是static的
        System.out.println(say.invoke(null, 1, "hi", 'X')); // 1 hi X
        // 5. 在反射中，如果方法有返回值，统一返回Object，但是运行类型和方法定义的返回类型是一致的
        Object reVal = say.invoke(o, 100, "lufee", 'D');
        System.out.println("reVal的返回类型=" + reVal.getClass());   // String
    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }
}