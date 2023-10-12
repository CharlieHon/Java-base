package com.hspedu.encap;

public class Encap01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Bruce");
        person.setAge(22);
        person.setSalary(30000.);
        System.out.println(person.info());

        Person smith = new Person("smith", 36, 50000.);
        System.out.println(smith.info());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        // 在构造器种调用 setXXX，这样仍然可以验证数据
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // 快捷键，写 setXXX() 和 getXXX()
    // 然后根据要求来完善代码
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 加入对数据的校验
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字的长度不对，需要2~6个字符，默认名字：无名");
            this.name = "无名";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄需要在1~120之间，默认年龄：18");
            this.age = 18;
        }
    }

    public double getSalary() {
        // 可以增加对当前对象的查看
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "信息-姓名：" + name + "，年龄：" + age + "，工资：" + salary;
    }
}