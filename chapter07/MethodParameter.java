package chapter07;

public class MethodParameter {
    public static void main(String[] args) {
        /** 成员方法传参机制
         * 1. 基本数据类型，传递的是值(值拷贝)，形参的任何改变不影响实参！
         * 2. 引用数据类型的传参机制
         *      引用类型传递的是地址(传递的也是值，但是值是地址)，可以通过形参影响实参
         *  
         */
        A a = new A();
        int x = 6, y = 9;
        a.swap1(x, y);
        System.out.println("x = " + x + ", y = " + y);

        // 传入引用数据类型
        int[] arr1 = {1, 8, 9, 5};
        a.test100(arr1);
        System.out.println(arr1[0]);    // 200

        // 测试
        Person p = new Person();
        p.name = "Charlie";
        p.age = 21;
        a.test200(p);
        System.out.println("p.age = " + p.age);
    }
}

class Person {
    String name;
    int age;
}

class A {
    public void swap1(int a, int b) {
        System.out.println("before swap: a = " + a + ", b = " + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("after swap: a = " + a + ", b = " + b);
        return;
    }

    public void test100(int[] arr) {
        arr[0] = 200;
        return;
    }

    public void test200(Person p) {
        p.age = 66;
        return;
    }
}