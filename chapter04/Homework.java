package chapter04;

public class Homework {
    public static void main(String[] args) {
        System.out.println(10 / 3); // 3
        System.out.println(10 / 5); // 2
        System.out.println(10 % 2); // 0
        // a % b 当a是小数时，结果为 a - (int)a/b*b
        System.out.println(-10.5 % 3);  // -10.5 - (int)(-10.5)/3*3 = -1.5
        
        int i = 66;
        System.out.println(++i+i);  // 134

        // 判断对错
        // int num1 = (int)"18";   // 错误：Integer.parseInt("18");
        // int num2 = 18.0;    // 错误：类型不匹配，不能自动转换 double -> int
        double num3 = 3d;   // 正确：以d结尾表示double字面值(不是十六进制)
        double num4 = 8;    // 正确：可以自动转换 int -< double
        // int i = 48; char ch = i + 1;    // 错误：i + 1 -> int X-> char
        // byte b = 18; short s = b + 2;   // 错误：b + 2 -> int X-> short
    
        // 将String转换为double类型，将char类型转换成String
        double d = Double.parseDouble("3.14");
        System.out.println(d);  // 3.14
        String s = '韩' + "";
        System.out.println(s);  // 韩
    }
}