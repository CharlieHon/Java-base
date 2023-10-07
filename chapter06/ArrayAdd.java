package chapter06;
import java.util.Scanner;
public class ArrayAdd {
    public static void main(String[] args) {
        // 实现动态的给数组添加元素效果，实现对数组扩容
        // int[] arr = {1, 2, 3};
        // int[] arr1 = new int[arr.length+1];
        // for (int i = 0; i < arr.length; ++i) {
        //     arr1[i] = arr[i];
        // }
        // arr1[arr1.length - 1] = 4;
        // arr = arr1; // 将 arr 指向 arr1，原来arr数组就被销毁
        // for (int i = 0; i < arr.length; ++i) {
        //     System.out.println(arr[i]);
        // }
        
        int[] arr = {1, 2, 3};
        int[] arrNew;
        // 创建一个Scanner，根据用户输入y/n，判断是否继续添加
        Scanner myScanner = new Scanner(System.in);
        do {
            arrNew = new int[arr.length + 1];
            for (int i = 0; i < arr.length; ++i) {
                arrNew[i] = arr[i];
            }
            System.out.println("请输入您要添加的元素：");
            int x = myScanner.nextInt();
            arrNew[arrNew.length - 1] = x;
            arr = arrNew;
            System.out.println("是否继续添加元素？(y/n)");
            char c = myScanner.next().charAt(0);
            if (c == 'n')   break;
        } while (true);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
