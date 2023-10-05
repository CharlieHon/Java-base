package chapter04;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        /** 
         * 在编程中，需要接收用户输入的数据，就可以使用键盘输入语句来获取
         * 需要一个扫描器(对象)，就是 Scanner
         * 1. 导入该类的所在包，java.util.*
         * 2. 创建该类对象(声明变量)
         * 3. 调用里面的功能
        */
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = myScanner.next(); // 当程序执行到 next 方法时，会等待用户输入~~
        System.out.println("请输入年龄：");
        int age = myScanner.nextInt();
        System.out.println("请输入薪水：");
        double salary = myScanner.nextDouble();
        System.out.println("基本信息如下：");
        System.out.println("名字：" + name 
            + "，年龄：" + age + "，薪水：" + salary);
    }
}
