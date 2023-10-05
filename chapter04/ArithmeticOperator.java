package chapter04;

public class ArithmeticOperator {
    public static void main(String[] args) {
        // /使用
        System.out.println(10 / 4); // 2
        System.out.println(10. / 4); // 2.5
        double d = 10 / 4;
        System.out.println(d);  // 2.0
        
        // %取模
        // 在Java中，%的本质为 公式 a % b = a - a / b * b
        // -10 % 3 = -10 - (-10)/3*3 = -10 + 9 = 1
        // 10 % -3 = 10 - 10/(-3)*(-3) = 10 - 9 = 1
        // -10 % -3 = -10 - (-10)/(-3)*(-3) = -10 + 9 = -1
        System.out.println(10 % 3); // 1
        System.out.println(-10 % 3);    // -1
        System.out.println(-10 % -3);   // -1

        // ++的使用
        int i = 100;
        i++;    // i = i + 1;
        ++i;    // i = i + 1;
        System.out.println("i = " + i); // 102
        /**
         * 作为表达式使用
         * ++i：先自增后赋值
         * i++：先赋值后自增
         */
        int j = 8;
        int k = j++;
        System.out.println("j = " + j + ", k = " + k);   // j = 9 k = 8
    
        // 练习
        int a = 1;
        a = a++;    // (1)tmp=a (2)a=a+1 (3)a=tmp;
        System.out.println(a);  // 1

        int b = 1;
        b = ++b;    // (1)b=b+1 (2)tmp=b (3)b=tmp
        System.out.println(b);  // 2
    }
}
