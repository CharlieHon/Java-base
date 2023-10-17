package com.hspedu.homework;

public class HomeWork01 {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Charlie", 21, "student"),
                new Person("Bruce", 19, "student"),
                new Person("John", 26, "teacher"),
                new Person("Tom", 32, "ceo"),
        };

        Person tmp = null;  // 临时变量，用于交换
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getAge() < people[j+1].getAge()) {
//                    Person tmp = new Person(people[j]);
//                    people[j].setName(people[j+1].getName());
//                    people[j].setAge(people[j+1].getAge());
//                    people[j].setJob(people[j+1].getJob());
//                    people[j+1].setName(tmp.getName());
//                    people[j+1].setAge(tmp.getAge());
//                    people[j+1].setJob(tmp.getJob());
                    tmp = people[j];    // 都是引用类型，可以直接指
                    people[j] = people[j+1];
                    people[j+1] = tmp;
                }
            }
        }

        // 输出Perosn数组信息
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person(Person p) {   // 不必这样复制拷贝，因为类对象是引用类型，可以直接改
        this.name = p.getName();
        this.age = p.getAge();
        this.job = p.getJob();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}