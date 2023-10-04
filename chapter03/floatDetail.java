package chapter03;

public class floatDetail {
    public static void main(String[] args) {
        // 浮点数类型
        // Java的浮点数类型(具体值)默认为double型，声明float型变量，须后加 'f' 或 'F'
        // float a = 1.1;   // 错误：
        float b = 1.34f;
        double c = 3.1415;
        /**
         * 浮点型常量有两种表示形式
         * 十进制数形式：如：5.12   512.0f  .512(必须有小数点)
         * 科学计数法形式：如：5.12e2   5.12e-2
        */ 
        double d = .512;
        double e = 5.12e-2;
        System.out.println(e);  // 0.0512
        // 通常情况下，使用double型，因为它比float型更精确
        double f = 3.1415926535456;
        float g = 3.1415926535456f;
        System.out.println(f);  // 3.1415926535456
        System.out.println(g);  // 3.1415927

        // 浮点数使用陷阱：2.7 和 8.1/3 比较
        double n1 = 2.7;
        double n2 = 8.1 / 3;
        System.out.println(n1); // 2.7
        System.out.println(n2); // 2.6999999999999997
        // 当我们对运算结果是小数的进行相等判断时，要小心
        // 应该是以两个数的插值的绝对值，子啊某个精度范围内判断
        if(n1 == n2) {
            System.out.println("n1 == n2: 相等");
        }
        // 正确写法
        if(Math.abs(n1 - n2) < 1e-8) {
            System.out.println("相等");
        }
    }
}
