package chapter04;

public class AssignOperator {
    public static void main(String[] args) {
        /** 赋值运算符
         * 1. 运算顺序从右往左
         * 2. 赋值运算符的左边 只能是变量，右边可以是变量、表达式、常量值
         *      int num = 20; int num2 = 78 * 34 - 10;
         * 3. 复合赋值运算符等价于如下效果。 a += 3 等价于 a = a + 3
         * 4. 复合运算符会进行类型转换。byte b = 2; b += 3; b++;
         */
        int n1 = 10;
        n1 += 4;
        System.out.println(n1); // 14
        n1 /= 3;
        System.out.println(n1); // 4
        byte b = 2;
        b += 3; // 等价于 b = (byte)(b + 3); 因为 b + 3结果为int型
        System.out.println(b);  // 5
        b++;    // 同样，底层有类型转换 b = (byte)(b + 1);
        System.out.println(b);  // 6
    }
}
