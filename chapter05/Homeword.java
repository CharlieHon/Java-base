package chapter05;
import java.util.Scanner;
public class Homeword {
    public static void main(String[] args) {
        // 01.过路口
        double money = 100000.;
        int cnt = 0;
        while (true) {
            if (money > 50000.) {
                money *= 0.95;
            } else if (money >= 1000.) {
                money -= 1000.;
            } else {
                break;
            }
            ++cnt;
        }
        System.out.println("cnt = " + cnt);

        // 02.判断整数
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int x = myScanner.nextInt();
        if (x > 0) {
            System.out.println(x + " > 0");
        } else if (x == 0) {
            System.out.println(x + " == 0");
        } else {
            System.out.println(x + " < 0");
        }

        // 03.判断是否是闰年
        System.out.println("请输入一个年份：");
        int year = myScanner.nextInt();
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + "年是闰年！");
        } else {
            System.out.println(year + "是平年！");
        }

        // 04.水仙花数
        System.out.println("请输入一个三位整数");
        int y = myScanner.nextInt();
        int sum = 0, tmp = y;
        while (y != 0) {
            sum += (y % 10) * (y % 10) * (y % 10);
            y /= 10;
        }
        if (sum == tmp) {
            System.out.println(tmp + "是水仙花数！");
        } else {
            System.out.println(tmp + "不是水仙花数！");
        }

        // 06.
        for (int i = 1, count = 0; i <= 100; ++i) {
            if (i % 5 != 0) {
                System.out.print(i + "\t");
                ++count;
                if (count % 5 == 0) {
                    System.out.print("\n");
                }
            }
        }

        // 07.输出小写字母a-z以及大写字母Z-A
        for (char c = 'a'; c <= 'z'; ++c) {
            System.out.print(c + " ");
        }
        System.out.println("");
        for (char c = 'Z'; c >= 'A'; --c) {
            System.out.print(c + " ");
        }
        System.out.println("");

        // 08
        double sum1 = 0.;
        for (int i = 1, j = -1; i <= 100; ++i) {
            j *= -1;
            sum1 += 1. / i * j;
        }
        System.out.println("1-1/2+1/3-1/4...1/100 = " + sum1);

        // 09
        int sum2 = 0;
        for (int i = 1; i <= 100; ++i) {
            for (int j = 1; j <= i; ++j) {
                sum2 += j;
            }
        }
        System.out.println("sum2 = " + sum2);
    }
}
