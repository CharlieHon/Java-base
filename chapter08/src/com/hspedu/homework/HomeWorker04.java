package com.hspedu.homework;

public class HomeWorker04 {
    public static void main(String[] args) {
        Manager bruce = new Manager("Bruce", 1000, 20, 1.2);
        // 设置奖金
        bruce.setBonus(30000);
        // 打印经理的工资
        bruce.printSal();

        Worker tom = new Worker("Tom", 300, 25, 1);
        tom.printSal();
    }
}
