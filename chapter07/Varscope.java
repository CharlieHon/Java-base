package chapter07;

public class Varscope {
    public static void main(String[] args) {
        /** 作用域
         * - 属性声明周期较长，伴随着对象的创建而创建，伴随着对象的销毁而销毁。
         * - 局部变量生命周期短，伴随着代码块的执行而创建，伴随着代码块的结束而销毁，即在一次方法调用过程中
         * 作用域范围不同
         *  - 全局变量/属性：可以被本类使用，或其他类使用(通过对象调用)
         *  - 局部变量：只能在本类中对应的方法中使用
         * 修饰符不同
         *  - 全局变量/属性可以加修饰符
         *  - 局部变量不可以加修饰符
         * 
         */
        Cat cat1 = new Cat();
        cat1.cry(); // 当执行cry方法时，cry的局部变量会创建，执行完毕后销毁，但是属性(全局变量)仍然可以使用
    }
}

class T {
    public void test() {
        Cat cat1 = new Cat();
        System.out.println(cat1.age);   // 10
    }

    public void test2(Person p) {
        System.out.println(p.age);  // 12
    }
}

class Cat {

    private double salary;  // 属性可以加修饰符，局部变量不可以

    // 全局变量：也就是属性，作用域为整个类体
    // 属性在定义时，可以直接幅值
    int age = 10;

    // 全局变量(属性)可以不赋值，直接使用，因为有默认值
    // 局部变量必须赋值后，才能使用，因为没有默认值
    double weight;  // 默认值是0.0

    public void cry() {
        // 1. 局部变量一般是指在成员方法中定义的变量
        // 2. n和name就是局部变量，作用域在 cry 方法中
        int n = 10;
        String name = "Jack";
        System.out.println("在cry中使用属性 age = " + age);
    }

    public void hi() {
        int num;    // 局部变量必须赋值后才能使用
        int age = 12;   // 属性和局部变量可以重名，访问时遵循就近原则
        // int age = 13;    // 错误：在同一个作用域中，两个局部变量不能重复定义，不能重名
        System.out.println("hi(): age = " + age);
    }
}