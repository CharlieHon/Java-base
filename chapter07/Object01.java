package chapter07;
public class Object01 {
    public static void main(String[] args) {
        /**
         * 1. 类是抽象的，概念的，代表一类事物，比如人类、猫类，即它是数据类型
         * 2. 对象是具体的，实际的，代表一个具体事物，即实例
         * 3. 类是对象的模板，对象是类的一个个体，对应一个实例
         */
        // 使用OOP面向对象解决，实例化一只猫
        // 1. new Cat() 创建一只猫
        // 2. Cat cat1 = new Cat(); 把创建的猫赋值给 cat1
        Cat cat1 = new Cat();
        cat1.name = "小白";
        cat1.age = 3;
        cat1.color = "橘色";
        cat1.weight = 6.;
        // 创建第二只猫
        Cat cat2 = new Cat();
        cat2.name = "小花";
        cat2.age = 100;
        cat2.color = "花色";
        cat2.weight = 15.;

        // 怎么使用对象的属性
        System.out.println("第一只猫信息：" + cat1.name + " "
            + cat1.age + " " + cat1.color);

        // 对象在内存中的存在形式
        // 类、数组、接口、String都是引用类型
    }
}

// 使用面向对象的方式
// 定义一个猫类 Cat
class Cat {
    // 属性，也叫成员变量，字段field
    String name;
    int age;
    String color;
    double weight;
    String[] master;    // 属性可以是基本数据类型，也可以是引用类型(对象，数组)
    // 行为
}