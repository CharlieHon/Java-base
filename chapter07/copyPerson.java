package chapter07;

public class copyPerson {
    public static void main(String[] args) {
        // 拷贝一个对象，使得二者属性相同
        Person p1 = new Person();
        p1.name = "小白";
        p1.age = 12;
        MyTools tools = new MyTools();
        Person p2 = tools.copyPerson(p1);
        // p1和p2是两个独立的对象，只是属性相同
        System.out.println("p1: " + p1.name + ", " + p1.age);
        System.out.println("p2: " + p2.name + ", " + p2.age);
        // 比较两个对象是否为同一个对象？
        System.out.println(p1 == p2);   // false
    }
}

class Person {
    String name;
    int age;
}

class MyTools {
    public Person copyPerson(Person p1) {
        // 创建一个新的对象
        Person p2 = new Person();
        p2.name = p1.name;
        p2.age = p1.age;
        return p2;
    }
}