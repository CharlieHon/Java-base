package com.hspedu.homework.homework5;

public class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.print("科学家：");
        System.out.println(
                getName() + " 工资="
                        + (bonus + getSalary())
        );
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
