package com.hspedu.extend_;

import sun.plugin2.gluegen.runtime.CPU;

public class ExtendExercise {
    public static void main(String[] args) {
        PC pc = new PC("intel", 16, 500, "IBM");
        pc.printInfo();
    }
}

class Computer {
    private String cpu;
    private int memory;
    private int disk;

    public Computer(String CPU, int memory, int disk) {
        this.cpu = CPU;
        this.memory = memory;
        this.disk = disk;
    }

    // 返回Computer信息
    public String getDetails() {
        return "cpu=" + cpu + ", memory=" + memory + ", disk=" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public int getDisk() {
        return disk;
    }
}

class PC extends Computer {
    String brand;

    public PC(String CPU, int memory, int disk, String brand) {
        super(CPU, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println("PC信息：");
        System.out.println(getDetails() + ", brand=" + brand);
    }
}