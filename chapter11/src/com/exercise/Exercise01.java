package com.exercise;

public class Exercise01 {
    public static void main(String[] args) {
//        System.out.println(Frock.getNextNum());
//        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock.getSerialNumber() + ", " + frock1.getSerialNumber()
        + ", " + frock2.getSerialNumber()); // 100100, 100200, 100300
    }
}

@SuppressWarnings({"all"})
class Frock {
    private static int currentNum = 100000;

    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}