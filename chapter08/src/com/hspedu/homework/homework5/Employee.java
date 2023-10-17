package com.hspedu.homework.homework5;

public class Employee {
    private String name;
    private double salary;  // 基本工资

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void printSal() {
        System.out.println(
                name + " 工资=" + salary
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
