package com.annotation_;

public class Override_ {

}

class Father {
    public void fly() {
        System.out.println("Father: fly...");
    }
}

class Son extends Father {
    // 1. @Override 注解，放在fly方法上，表示子类的方法重写了父类的fly方法
    // 2. 如果不写 @Override 注解，还是重写父类fly方法
    // 3. 加上注解，编译器就会去检查该方法是否真的重写了父类的方法
    // 如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    // 4. @Override 的定义
    /* 如果发现 @interface 表示一个 注解类
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override {
    }
     */
    @Override
    public void fly() {
        System.out.println("Son: fly...");
    }

//    @Override   // 错误：编译器进行语法校验，发现不构成重写
//    public void say() {}
}