package chapter07;

public class This {
    public static void main(String[] args) {
        /** This
         * 1. this关键字可以用来访问本类的属性、方法、构造器
         * 2. this用于区分当前类的属性和局部变量
         * 3. 访问成员方法的语法：this.方法名(参数列表)
         * 4. 访问构造器语法：this(参数列表)；只能在构造器中使用
         *      即，只能在构造器中访问另外一个构造器
         *      并且必须放在第一条语句
         * 5. this不能再类定义的外部使用，只能在类定义的方法中使用
         */
        T t1 = new T();
        t1.f2();
    }
}

class T {

    String name;
    int age;

    public T() {
        // 注意：如果有this(参数列表);
        // 则该语句必须放在第一条语句
        this("jack", 100);
        System.out.println("T() 构造器");
    }
    public T(String name, int age) {
        System.out.println("T(String name, int age) 构造器");
    }

    public void f1() {
        System.out.println("f1() 方法...");
    }
    
    public void f2() {
        System.out.println("f2() 方法...");
        // 调用本类的f1
        f1();
        this.f1();
    }

    public void f3() {
        System.out.println("name = " + name + " age = " + age);
        System.out.println("this.name = " + this.name + " this.age = " + this.age);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}

class Book {
    String name;
    double price;

    public Book() {}
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        if(this.price > 150) {
            this.price = 150;
        } else if(this.price > 100) {
            this.price = 100;
        }
    }
}