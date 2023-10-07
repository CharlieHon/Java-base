package chapter07;
public class Method01 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.speak();
        p1.cal01();
        p1.cal02(50);

        // 调用getSum方法，a = 10, b = 20
        // 把方法 getSum 返回的值，赋给变量 res
        int res = p1.getSum(10, 20);
        System.out.println("10 + 20 = " + res);
        /** 方法调用
         * 1. 当程序执行到方法时，就会开辟一个独立的空间(栈空间)
         * 2. 当方法执行完毕，或者执行到return语句时，就会返回
         * 3. 返回到调用方法的地方
         * 4. 返回后，继续执行方法后面的代码
         * 5. 当main方法(栈)执行完毕，整个程序退出
         */
    }
}

class Person {
    String name;
    int age;

    // 1. public：表示方法是公开
    // 2. void：表示方法没有返回值
    // 3. speak()：speak是方法名，()是形参列表
    // 4. {}：方法体，可以写要执行的代码
    public void speak() {
        System.out.println("我是好人");
    }

    public void cal01() {
        int res = 0;
        for (int i = 1; i <= 100; ++i) {
            res += i;
        }
        System.out.println("sum from 1 to 100 is " + res);
    }

    // 1. (int n)：形参列表，表示当前有一个形参 n，可以接收用户输入
    public void cal02(int n) {
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res += i;
        }
        System.out.println("sum from 1 to " + n + " is " + res);
    }

    // 1. public：表示方法是公开的
    // 2. int：表示方法执行后，返回一个 int 值
    // 3. getSum：方法名
    // 4. (int a, int b)：形参列表，接收两个形参
    // 5. return res; 表示把 res 的值，返回
    public int getSum(int a, int b) {
        int res = a + b;
        return res;
    }
}