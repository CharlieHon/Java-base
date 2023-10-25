package com.hspedu.innerclass_;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        // 外部其他类，使用成员内部类的三种方式
        // (1). outer08.new Inner08();   相当于把 new Inner08() 当作 outer08的成员
        //  这就是一个语法，不要特别纠结
        Outer08.Inner08 inner08 = outer08.new Inner08();
        // (2). 通过外部类的方法返回一个成员内部类对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
//        new Outer08().new Inner08();    // (3). 其实，同(1)
    }
}

class Outer08 { // 外部类
    private int n1 = 10;
    public String name = "张三";
    public void hi() {
        System.out.println("Outer08: hi()...");
    }
    // 1. 注意：成员内部类，是定义在外部类的成员位置
    // 2. 可以添加任意访问修饰符(`public, protected, 默认, private`)，因为它的地位就是一个成员
    public class Inner08 { // 成员内部类
        public double d1 = 0.8;
        public int n1 = 66; // 成员内部类 的成员和外部类成员重名
        public void say() {
            hi();   // 直接访问外部类成员
            System.out.println("Inner08 的 n1 = " + n1); // 遵循就近原则，访问成员内部类的成员
            // 访问外部类重名成员
            System.out.println("Outer08 的 n1 = " + Outer08.this.n1 + " name = " + name);
        }
    }

    // 通过外部类方法返回成员内部类对象
    public Inner08 getInner08Instance() {
        return new Inner08();
    }

    public void t1() {  // 使用成员内部类
        Inner08 inner08 = new Inner08();
        inner08.say();  // 通过创建对象，访问内部类成员
        System.out.println(inner08.d1);
    }
}