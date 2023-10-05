package chapter04;

public class TernaryOperator {
    public static void main(String[] args) {
        // 三元运算符
        int a = 10, b = 99;
        int res = (a > b) ? a++ : b--;
        System.out.println("a = " + a + ", b = " 
            + b + ", res = " + res);    // a = 10, b = 98, res = 99
        // 表达式1和表达式2要为可以赋值给接收变量的类型(或可以自动转换/强制转换)
        int c = a > b ? (int)1.1 : (int)3.4;
        double d = a > b ? a : b + 3;   // 可以，满足 int -> double
        // 三元运算符可以转成 if-else 语句

        int n1 = 55, n2 = 33, n3 = 123; // 案例：实现三个数的最大值
        int res2 = n1 > n2 ? (n1 > n3 ? n1 : n3) : (n2 > n3 ? n2 : n3);
        System.out.println(res2);   // 123
    }
}
