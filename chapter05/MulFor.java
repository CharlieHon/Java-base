package chapter05;
import java.util.Scanner;
public class MulFor {
    public static void main(String[] args) {
        double sum1 = 0., sum2 = 0.;
        double score;
        int cnt = 0; // 统计三个班的及格情况
        Scanner myScanner = new Scanner(System.in);
        for (int i = 1; i <= 3; ++i) {
            for (int j = 1; j <= 5; ++j) {
                System.out.println("请输入第" + i + "班的第" + j + "学生的成绩");
                score = myScanner.nextDouble();
                if (score >= 60.)   ++cnt;
                sum1 += score;
                sum2 += score;
            }
            sum1 /= 5;
            System.out.println("班级" + i + "的平均分是" + sum1);
            sum1 = 0.;
        }
        System.out.println("所有班级的平均分是" + (sum2 / 15));
        System.out.println("共有" + cnt + "个及格人数~");

        // 打印九九乘法表
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.print("\n");
        }
    }
}
