package com.exercise;

public class Exercise03 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        // 1. 匿名内部类是
        /*
        new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }
         */
        // 同时也是对象，编译类型：ICalculate，运行类型：匿名内部类
        cellPhone.testWork(new ICalculate() {   // Exercise03$1
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);  // 10

        cellPhone.testWork(new ICalculate() {   // Exercise03$2
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 8);  // 80
    }
}

interface ICalculate {
    double work(double n1, double n2);
}

class CellPhone{
    public void testWork(ICalculate iCalculate, double n1, double n2) {
        double result = iCalculate.work(n1, n2);    // 动态绑定
        System.out.println("计算结果=" + result);
    }
}