package com.hspedu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException {
        // 得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");

        // getDeclaredFields：获取本类中所有属性(所有访问权限的，不包含父类)
        // getModifiers()：返回属性的修饰符，规定：默认修饰符是0，public是1，private是2，protected是4，static是8，final是16
        //
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性" + declaredField.getName()
            + "，该属性的修饰符=" + declaredField.getModifiers()
            + "，该属性的类型=" + declaredField.getType());
        }

        // getDeclaredMethods：获取本类中所有方法   m1 m2 m3 m4
        System.out.println("======");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
            + "，该方法的访问修饰符=" + declaredMethod.getModifiers()
            + "，该方法的返回类型=" + declaredMethod.getReturnType());

            // 输出档期方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        // getDeclaredConstructors：获取本类所有构造器
        System.out.println("======");
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器" + declaredConstructor.getName());
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }
    }

    @Test
    public void api_01() throws ClassNotFoundException {
        // 得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");

        // getName：得到全类名
        System.out.println(personCls.getName());    // com.hspedu.reflection.Person

        // getSimpleName：获取简单类名
        System.out.println("======");
        System.out.println(personCls.getSimpleName());  // Person

        // getFields：获取所有public修饰的属性，包含本类以及父类的
        System.out.println("======");
        Field[] fields = personCls.getFields();
        for (Field field : fields) {    // name hobby 仅显示public的
            System.out.println("本类以及父类的属性=" + field.getName());
        }

        // getDeclaredFields：获取本类中所有属性(所有访问权限的，不包含父类)
        System.out.println("======");
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性" + declaredField.getName());
        }

        // getMethods：获取所有public修饰的方法，包含本类以及父类的
        System.out.println("======");
        Method[] methods = personCls.getMethods();
        for (Method method : methods) { // 父类不局限于直接父类，包括超类 Object等
            System.out.println("本类以及父类的方法" + method.getName());
        }

        // getDeclaredMethods：获取本类中所有方法   m1 m2 m3 m4
        System.out.println("======");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        // getConstructors：获取所有public修饰的构造器，仅包含本类
        System.out.println("======");
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类及父类构造器" + constructor.getName());
        }

        // getDeclaredConstructors：获取本类所有构造器
        System.out.println("======");
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器" + declaredConstructor.getName());
        }

        // getPackage：以Package形式返回 包信息
        System.out.println("======");
        System.out.println(personCls.getPackage()); // package com.hspedu.reflection

        // ：以Class形式返回父类信息
        System.out.println("======");
        System.out.println("父类Class对象" + personCls.getSuperclass());  // class com.hspedu.reflection.A

        // ：以Class[]形式返回接口信息
        System.out.println("======");
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());  // IA Ib
        }

        // ：以Annotation[] 形式返回注解信息
        System.out.println("======");
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);   // 注解信息=@java.lang.Deprecated()
        }
    }
}

class A {
    public String hobby;
    public void hi() {

    }

    public A() {
    }
}

interface IA {

}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    // 属性
    public String name;
    protected static int age;
    String job;
    private double sal;
    // 构造器

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }
    private void m4() {

    }
}