package chapter05;
import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {
        /** switch
         * 1. switch关键字，表示switch分支
         * 2. 表达式对应一个值
         * 3. case 常量1: 当表达式的值等于常量1时，执行语句块1
         * 4. break：表示退出switch
         * 5. 如果和case1 常量1匹配，就执行语句块1，如果没有匹配就继续匹配case 常量2
         * 6. 如果一个都没有匹配上，执行 default
         */
        // 当某一个case的执行语句中没有break语句时，
        // 会直接执行下一个case的执行语句，而不进行case判断
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入字母：");
        char day = myScanner.next().charAt(0);  // 接收一个字符
        switch (day) {
            case 'a':
                System.out.println("星期一");
                break;
            case 'b':
                System.out.println("星期二");
                break;
            case 'c':
                System.out.println("星期三");
                break;
            case 'd':
                System.out.println("星期四");
                break;
            case 'e':
                System.out.println("星期五");
                break;
            default:
                System.out.println("Happy!");
                break;
        }

        /** switch细节事项
         * 1. 表达式数据类型，应和case后的常量类型一致，或者是可以自动转成相互比较的类型
         *      比如输入的是字符，而常量是int
         * 2. switch(表达式)中表达式的返回值必须是：(byte, short, int, char, enum, String)
         * double c = 1.1;
         * switch (c) {
         *      case 1.1:
         *          System.out.println("ok3");
         *          break;
         * }
         * 3. case子句中的值必须是常量(表达式)，而不能是变量
         * 4. default子句是可选的，当没有匹配的case时，执行default
         * 5. break语句用来在执行完一个case分支后使程序跳出switch语句块；
         *      如果没有写break，程序会顺序执行到switch结尾
         */

        char c = 'c';
        switch (c) {
            case 'a':
                System.out.println("ok1");
                break;
            case 98:    // 'b'
                System.out.println("ok2");
            case 'b' + 1:   // 常量表达式
                System.out.println("ok3");
                // 没有break，会贯穿下去，不进行判断而直接执行case 'd'的语句
            case 'd':
                System.out.println("ok4");
                break;
            default:
                System.out.println("ok");
                break;
        }
        
        // double d1 = 1.3;
        // switch (d1) {   // 表达式的返回值是double，不行
        //     case 1.1:
        //         System.out.println("ok1");
        //         break;
        // }

        System.out.println("请输入字母：");
        char key = myScanner.next().charAt(0);
        switch (key) {
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("other");
                break;
        }

        System.out.println("请输入成绩：");
        double score = myScanner.nextDouble();
        switch ((int)(score / 60)) {
            case 0:
                System.out.println("不合格");
                break;
            case 1:
                System.out.println("合格");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }

        System.out.println("请输入月份：");
        int month = myScanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("月份错误！");
                break;
        }
    }
}
