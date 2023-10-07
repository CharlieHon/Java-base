package chapter05;
import java.util.Scanner;
public class For {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        for(int i=0; i<n; ++i) {
            System.out.println("Hello: " + i);
        }
        /** for循环细节说明
         * 1. 循环条件是返回一个布尔值的表达式
         * 2. for(;循环条件;) 中初始化和变量迭代可以写到其他地方，但是量表的分号不能省略
         * 3. 循环初始值可以有多条初始化语句，但是要求类型一样，并且中间用逗号哥开
         *      循环遍历迭代也可以有多条变量迭代器语句，中间用逗号隔开
         */
        // for(;;) {   // 是一种无限循环，死循环
        //     System.out.println("ok+");
        // }

        int count = 0, sum = 0;
        for (int i=1; i<=100; ++i) {
            if (i % 9 == 0) {
                ++count;
                sum += i;
            }
        }
        System.out.println("1~100中9的倍数有" + count + "个\n总和为" + sum);

        int n2 = 6;
        for (int i = 0; i <= n2; ++i) {
            System.out.println(i + " + " + (n2 - i) + " = " + n2);
        }
    }
}
