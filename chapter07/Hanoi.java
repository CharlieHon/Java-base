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

    /** 猴子吃桃问题
     * 猴子第一天吃一半的桃子，再多吃一个；第二天吃剩余的一半的桃子，再多吃一个
     * 到10天时，就只剩下了1个桃子。
     * 求第 n 天，桃子的个数
     */
    public int Peach(int day) {
        if (day == 10) {
            return 1;
        }
        return (Peach(day + 1) + 1) * 2;
    }
}