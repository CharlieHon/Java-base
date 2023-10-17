package com.hspedu.homework;

public class Worker extends Employee {
    // 特有属性：无

    public Worker(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }

    @Override
    public void printSal() {
        // 因为普通员工和Employee工资情况一样，所以直接调用父类的printSal()
        System.out.print("员工：");    // 自己的输出信息
        super.printSal();
    }
}
