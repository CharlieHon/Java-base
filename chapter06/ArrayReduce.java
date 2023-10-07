package chapter06;
import java.util.Scanner;
public class ArrayReduce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            if (arr.length == 1) {
                System.out.println("只剩下一个元素，不能再缩减了");
                break;
            }
            int[] arrNew = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; ++i) {
                arrNew[i] = arr[i];
            }
            arr = arrNew;
            System.out.println("请问是否继续缩减？(y/n)");
            char key = myScanner.next().charAt(0);
            if(key == 'n')  break;
        }
        System.out.println("缩减结束！");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
