package chapter07;

public class VarParameter {
    public static void main(String[] args) {
        /** 可变参数
         * - java中允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法
         * 基本语法：
         *  访问修饰符 返回类型 方法名(数据类型... 形参名) {
         *  }
         * 1. 可变参数的参数的个数可以是0个，也可以是多个
         * 2. 可变参数的实参可以是数组，可变参数的本质就是数组
         * 3. 可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
         * 4. 一个形参列表中只能出现一个可变参数
         */
        T t = new T();
        System.out.println(t.sum());
        System.out.println(t.sum(10));  // 还是执行可变参数方法
        System.out.println(t.sum(1, 8, 9, 5));
        int[] arr1 = {1, 2, 3};
        System.out.println(t.sum(arr1));

        t.test("Bruce", 90, 88, 96);
    }
}
class T {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
    // 上面两个方法名相同，功能相同，参数个数不同 -> 使用可变参数优化
    // 1. int... 表示接收的是可变参数，类型是int，即可以接收多个int(0或多个)
    // 2. 使用可变参数时，可以当作数组来使用，即 parameters 可以当作数组
    // 3. 遍历 parameters 求和即可
    public int sum(int... parameters) {
        System.out.println("接收参数个数：" + parameters.length);
        int res = 0;
        for (int elem : parameters) {
            res += elem;
        }
        return res;
    }

    // 可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
    public void f1(String str, double... nums) {
    }
    // public void f2(double... nums1, int... nums2) {} // 错误：一个形参列表仅能只有一个可变参数

    public void test(String str, int... scores) {
        int res = 0;
        for (int score : scores) {
            res += score;
        }
        System.out.println(str + res);
    }
}