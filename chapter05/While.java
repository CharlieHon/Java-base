package chapter05;
import java.util.Scanner;
public class While {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            System.out.println("Hello" + i);
            ++i;
        }
        System.out.println("你好" + i); // 11

        int x = 1;
        while (x <= 100) {
            if (x % 3 == 0) System.out.println(x);
            ++x;
        }

        System.out.println("=========");
        int y = 40;
        while(y <= 200) {
            if (y % 2 == 0) System.out.println(y);
            ++y;
        }

        // do while; 先执行，后判断。至少执行一次
        int z = 1, sum = 0;
        do {
            sum += z;
            ++z;
        } while(z <= 100);
        System.out.println("Sum from 1 to 100 is " + sum);
    
        Scanner myScanner = new Scanner(System.in);
        char c;
        do {
            System.out.println("松果弹抖闪电鞭~");
            System.out.println("是否还钱？y/n");
            c = myScanner.next().charAt(0);
        } while (c != 'n');
    }
}
