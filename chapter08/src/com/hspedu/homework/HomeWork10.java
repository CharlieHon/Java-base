package com.hspedu.homework;

import javax.print.Doc;

public class HomeWork10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("张三", 23, "牙医", '男', 3000);
        Doctor doctor1 = new Doctor("张三", 23, "牙医", '男', 3000);
        Doctor doctor2 = new Doctor("李四", 23, "护士", '男', 3000);
        System.out.println(doctor.equals(doctor1)); // true
        System.out.println(doctor.equals(doctor2)); // false
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        // 判断两个比较对象是否相同
        if (this == obj) {  // 同一个对象
            return true;
        }
        if (obj instanceof Doctor) {    // 判断 obj 是否是 Doctor类型或其子类
            Doctor d = (Doctor) obj;    // 向下转型
            return this.name.equals(d.name) && this.age == d.age && this.job.equals(d.job)
                    && this.gender == d.gender && this.sal == d.sal;
        }
        return false;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}