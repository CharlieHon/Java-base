package chapter07;

public class Test {
    int count = 9;  // 属性
    public void count1() {  // Test类的成员方法
        count = 10; // 这个count就是属性，改成10
        System.out.println("count1 = " + count);    // 10
    }
    public void count2() {
        System.out.println("count2 = " + count++);
    }

    // 这是main，任何一个类，都可以有main
    public static void main(String[] args) {
        // 1. new Test() 是匿名对象，只用使用一次
        // 2. new Test().count1() 创建好匿名对象后，就调用count1()
        new Test().count1();    // 10
    
        Test t1 = new Test();
        t1.count2();    // 9
        t1.count2();    // 10

        Circle c = new Circle();
        PassObject po = new PassObject();
        po.printAreas(c, 5);
    }
}

class Circle {
    double radius;
    public Circle() {};
    public Circle(double radius) {
        this.radius = radius;
    }
    public double findArea() {
        return Math.PI * this.radius * this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class PassObject {
    public void printAreas(Circle c, int times) {
        for(int r = 1; r <= times; ++r) {
            c.setRadius(r);
            System.out.println("r = " + r + ", area = " + c.findArea());
        }
    }
}