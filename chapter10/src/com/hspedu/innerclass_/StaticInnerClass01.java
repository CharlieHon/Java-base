package com.hspedu.innerclass_;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer09 outer09 = new Outer09();
        outer09.show();

        // 外部其他类 使用静态内部类
        // (1). 因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        Outer09.Inner09 inner09 = new Outer09.Inner09();
        inner09.say();
        // (2). 编写一个方法，可以返回静态内部类的对象
        Outer09.Inner09 inner09Instance = outer09.getInner09Instance();
        inner09Instance.say();
        // (3). 通过静态方法，不需要创建对象，直接返回 静态内部类 的对象
        Outer09.Inner09 inner09Instance1 = Outer09.getInner09Instance_();
        inner09Instance1.say();
    }
}

class Outer09 { // 外部类
    private int n1 = 10;
    private static String name = "张三";
    // Inner09就是静态内部类
    // 1. 放在外部类的成员位置
    // 2. 使用 static 修饰
    // 4. 可以添加任意访问修饰符
    public static class Inner09 {
        private static String name = "李四";
        public void say() {
            // 3. 直接访问外部类的静态成员
            System.out.println(name);   // 成员重名时，访问遵循就近原则
            System.out.println("Outer09.name = " + Outer09.name);
            // 不能直接访问外部类的非静态成员
//            System.out.println(n1);
        }
    }

    public void show() {
        // 5. 作用域：同其他的成员，为整个类体
        Inner09 inner09 = new Inner09();
        inner09.say();
    }

    // 返回静态内部类的一个实例化对象
    public Inner09 getInner09Instance() {
        return new Inner09();
    }

    // 通过一个静态方法返回，静态内部类的实例化对象
    public static Inner09 getInner09Instance_() {
        return new Inner09();
    }
}