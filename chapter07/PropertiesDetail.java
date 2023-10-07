package chapter07;

public class PropertiesDetail {
    public static void main(String[] args) {
        /** 属性注意事项和细节说明
         * 1. 属性的定义语法同变量，示例：访问修饰符 属性类型 属性名;
         *      访问修饰符：控制属性的访问范围
         *      有四种访问修饰符 public, protected, 默认, private
         * 2. 属性的定义类型可以为任意类型，包含基本类型或引用类型
         * 3. 属性如果不赋值，有默认值，规则和数组一致。
         */

        // 创建Person对象
        Person p1 = new Person();   // p1是对象名(对象引用)，new Person()创建的对象空间(数据)才是真正的对象
        // 对象的属性默认值，遵守数组规则
        System.out.println("当前人的个人信息：" + 
            p1.name + " " + p1.age + " " + p1.sal + " " + p1.isPass);   // null 0 0.0 false

        // 创建对象
        Person p2;      // 先声明，p2 -> null
        p2 = new Person();  // 再创建，在堆区创建数据，p2指向该数据区域

        // 直接创建
        Person p3 = new Person();

        // 访问属性
        p2.name = "小明";
    }
}

class Person {
    String name;
    int age;
    double sal;
    boolean isPass;
}

