package chapter07;
import java.util.Scanner;
public class Hanoi {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入汉诺塔中罗盘的个数：");
        int num = myScanner.nextInt();
        T t = new T();
        t.move(num, 'a', 'b', 'c');

        // 八皇后问题
    }
}

class T {
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + " -> " + c);
            return;
        }
        move(num-1, a, c, b);
        System.out.println(a + " -> " + c);
        move(num-1, b, a, c);
    }
}