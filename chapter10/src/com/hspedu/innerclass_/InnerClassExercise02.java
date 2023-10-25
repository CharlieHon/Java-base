package com.hspedu.innerclass_;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        // 测试手机类的闹钟功能
        CellPhone a = new CellPhone();
        // 1. 传递的实现了 Bell接口 的匿名内部类 InnerClassExercise02$1
        // 2. 重写了 ring()
        // 3. Bell bell = new Bell() {...};
        a.alarmClock(
                new Bell() {
                    @Override
                    public void ring() {
                        System.out.println("懒猪起床了...");
                    }
                }
        );
        a.alarmClock(
                new Bell() {
                    @Override
                    public void ring() {
                        System.out.println("小伙伴上课了...");
                    }
                }
        );
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
        System.out.println(bell.getClass());
    }
}