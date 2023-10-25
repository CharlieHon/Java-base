package com.hspedu.innerclass_;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        // 当做实参直接传递，简洁高效
        f1(     // 匿名内部类，class
                new IL() {
                    @Override
                    public void show() {
                        System.out.println("坚定不移！");
                    }
                }
        );
        // 传统方式：创建类实现接口，实例化类对象，通过对象调用方法
    }

    public static void f1(IL il) {
        il.show();
    }
}

interface IL {
    void show();
}