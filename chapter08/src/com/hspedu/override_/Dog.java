package com.hspedu.override_;

public class Dog extends Animal {
    // 1. Dog是Animal的子类
    // 2. Dog的cry方法和Animal的cry定义形式一样(名称、返回类型、参数)
    // 3. 覆盖
    public void cry() {
        System.out.println("小狗叫：汪汪汪...");
    }

    // 方法覆盖要求子类方法的返回类型和父类相同，或者父类返回类型的子类
    public String m1() {    // String 是 Object 的子类
        return null;
    }

    // 方法重写时，子类方法不能缩小父类方法的访问权限，可以扩大
    // public > protected > 默认 > private
    public void m2() {

    }
}
