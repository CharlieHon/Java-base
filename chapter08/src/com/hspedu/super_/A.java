package com.hspedu.super_;

public class A extends Base {
    // 四个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public A() {}
    public A(String name, int age) {}
    public A(String name) {}

    public void cal() {
        System.out.println("A.cal()...");
    }

    public void m1() {}
    protected void m2() {}
    void m3() {}
    private void m4() {}
}
