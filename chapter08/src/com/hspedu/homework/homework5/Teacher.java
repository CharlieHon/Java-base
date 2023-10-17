package com.hspedu.homework.homework5;

public class Teacher extends Employee {
    private double classSal;
    private int classDay;

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("教师：");
        System.out.println(
                getName() + " 工资"
                        + (getSalary() + classSal * classDay)
        );
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }
}
