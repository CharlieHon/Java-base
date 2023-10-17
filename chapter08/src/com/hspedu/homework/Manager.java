package com.hspedu.homework;

public class Manager extends Employee {
    // 特有属性
    private double bonus;

    // 创建Manager对象时，奖金是多少并不是确定的，因此在构造器中，不初始化bonus
    // 可以通过setBonus
    public Manager(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }

    // 重写打印方法
    @Override
    public void printSal() {
        // 因为经理的工资计算方式和Employee不一样，所以重写
        System.out.println( // 因为名字在父类，所以使用方法获得
                "经理：" + getName() + " 工资=" +
                        (bonus + getDaySal() * getWorkDays() * getGrade())
        );
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
