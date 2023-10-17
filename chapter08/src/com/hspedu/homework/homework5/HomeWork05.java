package com.hspedu.homework.homework5;

public class HomeWork05 {
    public static void main(String[] args) {
        Worker worker = new Worker("张三", 35000);
        worker.printSal();

        Teacher teacher = new Teacher("李明", 50000);
        teacher.setClassDay(22);
        teacher.setClassSal(100);
        teacher.printSal();

        Scientist scientist = new Scientist("李华", 70000);
        scientist.setBonus(50000);
        scientist.printSal();
    }
}
