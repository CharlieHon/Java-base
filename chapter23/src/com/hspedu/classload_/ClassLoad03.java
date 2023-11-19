package com.hspedu.classload_;

/**
 * 演示类加载-初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        // 1. 加载B类，并生成B的Class对象
        // 2. 连接 num = 10
        // 3. 初始化阶段
        //      依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，并进行合并
        /*
            <clinit>() {
                System.out.println("B 静态代码块被执行");
                num = 300;
                num = 100;
            }
            // 合并 -> num = 100
         */
        // new B() -> 执行构造器：B() 构造器被执行
//        new B();
//        System.out.println(B.num);  // B 静态代码块被执行   100
        // 看看加载类的时候，是由同步机制控制的
        B b = new B();
        /*
            protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
            {
                synchronized (getClassLoadingLock(name)) {
                // 保证某个类在内存中，只有一份Class对象
                }
            }
         */
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }
    static int num = 100;

    public B() {
        System.out.println("B() 构造器被执行");
    }
}