package com.hspedu.homework;

public class HomeWork03 {
    public static void main(String[] args) {
        Professor professor = new Professor("贾宝玉", 18, "高级职称", 30000, 1.3);
        professor.introduce();
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;    // 职称
    private double salary;  // 基本工资
    // 添加一个级别属性
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public void introduce() {
        System.out.println(
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary + '\'' +
                ", grade=" + grade
        );
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class Professor extends Teacher {

    // 可自行添加特殊属性
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是教授信息");
        super.introduce();
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是讲师信息：");
        super.introduce();
    }
}