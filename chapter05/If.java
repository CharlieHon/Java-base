package chapter05;
import java.util.Scanner;   // 导入
public class If {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in); // 定义一个Scanner对象
        System.out.println("请输入你的年龄：");
        int age = myScanner.nextInt();
        if (age >= 18) {
            System.out.println("Hello, world!");
        } else {    // 双分支
            System.out.println("Good good study!");
        }

        int x = 7, y = 4;
        if (x > 5) {
            if (y > 5) {
                System.out.println(x + y);
            }
                System.out.println("Charlie~"); // Charlie
        } else
            System.out.println("x is " + x);

        double a = 13.25, b = 3.14;
        if (a > 10. && b < 20.) 
            System.out.println(a + b);

        System.out.println("请输入一个年份：");
        int year = myScanner.nextInt();
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            System.out.println(year + "是闰年！");
        else
            System.out.println(year + "是平年！");

        System.out.println("请输入一个信用分(1~100):");
        int score = myScanner.nextInt();
        if (score >= 1 && score <= 100) {
            if (score == 100) {
                System.out.println("信用极好");
            } else if (score > 80 && score <= 99) {
                System.out.println("信用优秀");
            } else if (score >= 60) {
                System.out.println("信用一般");
            } else {
                System.out.println("不及格");
            }
        } else {
            System.out.println("信用分格式错误，请重新输入！");
        }

        boolean f = true;
        if (f = false) {    // f被赋值为false，表达式结果为赋值符号左边的变量，即false
            System.out.println("a");
        } else if (f) {
            System.out.println("b");
        } else if (!f) {
            System.out.println("c");    // c
        } else {
            System.out.println("d");
        }

        System.out.println("请输入成绩");
        double score2 = myScanner.nextDouble();
        if (score2 > 8.) {
            System.out.println("请输入性别");
            // next接受一个字符串，charAt()方法返回字符串某索引位置下的的字符
            char gender = myScanner.next().charAt(0);
            if (gender == '男')
                System.out.println("男子组晋级");
            else
                System.out.println("女子组晋级");
        } else {
            System.out.println("淘汰！");
        }

        int month = myScanner.nextInt();
        int age2 = myScanner.nextInt();
        if (month >= 4 && month <= 10) {
            if (age2 > 60) {
                System.out.println(20);
            } else if (age2 >= 18) {
                System.out.println(60);
            } else {
                System.out.println(30);
            }
        } else {
            if (age2 >= 18 && age2 <= 60)
                System.out.println(40);
            else
                System.out.println(20);
        }
    }
}