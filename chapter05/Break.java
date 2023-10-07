package chapter05;
import java.util.Scanner;
public class Break {
    public static void main(String[] args) {
        // 随机生成1~100的一个数，直到生成了97这个数，看看一共用了多少次
        int cnt = 0;
        int x;
        do {
            x = (int)(Math.random()*100) + 1;   // 生成 [1, 100)之间的一个随机数
            ++cnt;
            if (x == 97)    break;
        } while(true);
        System.out.println("一共" + cnt);

        /** break注意事项
         * 1. break语句出现在多层嵌套的语句块中，可以通过 标签 指明要终止的那一层语句块
         * 2. 没有指定 break，默认退出最近的循环体
         * 3. 标签名有程序员指定，在实际开发中应尽量避免使用标签
         * label01: {
         *      label02: {
         *          label03:
         *      }
         * }
         */
        label01:
        for (int i = 1; i <= 3; ++i) {
        label02:
            for (int j = 1; j <= 5; ++j) {
                if (j == 3) {
                    // 终止外层循环，整个循环结束
                    break label01;  // 如果不指定标签，则默认退出最近的一层循环
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
        System.out.println("Hi~");

        // 1~100以内的数求和，求出和第一次大于20的当前数
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            sum += i;
            if (sum > 20) {
                System.out.println("i = " + i);
                break;
            }
        }

        // 实现登录验证，有3次机会，如果用户名为"abc"，密码"666"提示登录成功
        // 否则提示还有几次机会
        Scanner myScanner = new Scanner(System.in);
        int chance = 3;
        String name = "", pw = "";
        for (int i = 1; i <= chance; ++i) {
            System.out.println("请输入用户名：");
            name = myScanner.next();
            System.out.println("请输入密码：");
            pw = myScanner.next();
            // 补充说明：字符串String相等判断使用equals方法
            if (name.equals("abc") &&  pw.equals("666")) {
                // "abc".equals(name);  // 推荐使用，可以避免空指针
                System.out.println("登录成功！");
                break;
            } else {
                System.out.println("还有" + (chance - i) + "次机会！");
            }
        }
    }
}
