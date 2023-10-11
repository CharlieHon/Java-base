package chapter07;
public class Constructor {
    public static void main(String[] args) {
        /** 构造函数
         * 构造函数是类的一种特殊方法，主要作用是完成对新对象的初始化。
         * - 方法名和类名相同
         * - 没有返回值
         * - 在创建对象时，系统会自动地调用该类的构造器完成对象的初始化
         * - 一个类可以定义多个构造器，即构造器重载
         * - 如果没有定义构造器，系统会自动给类生成一个默认无参构造(也叫默认构造方法)
         *      比如 Person(){} 使用javap指令反编译看看
         * - 一旦自定义构造器，默认的构造器就被覆盖了，就不能在使用默认的无参构造器，
         *      除非显式的定义一下，即：Person(){}
         * this关键字
         * - java虚拟机会给每个对象分配this，代表当前对象。
         */
        // 当 new 一个对象时，直接通过构造器指定名字和年龄
        Person p1 = new Person("Bruce", 21);
        Dog dog1 = new Dog();   // 使用默认无参构造器

    }
}

class Dog {
    /*
    默认构造器
    Dog(){}
     */
}

class Person {
    String name;
    int age = 18;
    // 构造器
    public Person(String name, int age) {
        this.name = name;   // this指代当前对象
        this.age = age;
        System.out.println("this.hashCode()=" + this.hashCode());   // 输出当前对象的“地址”
    }
    public Person() {   // 默认构造函数
        age = 18;
    }
}