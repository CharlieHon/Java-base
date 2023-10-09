package chapter06;
import java.util.Scanner;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
public class Homework {
    public static void main(String[] args) {
        // String str1[] = {'a', 'b', 'c'};    // char -> String(X)
        String[] str2 = {"a", "b", "c"};
        // String[] str3 = new String{"a", "b", "c"};
        String[] str4 = new String[] {"a", "b", "c"};
        // String[] str5 = new String[3] {"a", "b", "c"};  // 初始化时，无法指定数组大小
    
        String foo = "blue";
        boolean[] bar = new boolean[2];
        if (!bar[0]) {
            foo = "green";
        }
        System.out.println(foo);    // green

        // 升序数组添加一个元素
        int[] arr1 = {10, 12, 45, 90};
        int[] arr2 = new int[arr1.length + 1];
        System.out.println("请输入要添加的元素：");
        Scanner myScanner = new Scanner(System.in);
        int x = myScanner.nextInt();
        // for (int i = 0; i < arr1.length; ++i) {
        //     arr2[i] = arr1[i];
        // }
        // arr2[arr2.length-1] = x;    // 把原来数组和新元素都加进来
        
        // // 排序
        // for(int i = 1; i < arr2.length; ++i) {
        //     int tmp = arr2[i], k = i;
        //     while (k > 0 && tmp < arr2[k-1]) {
        //         arr2[k] = arr2[k-1];
        //         --k;
        //     }
        //     arr2[k] = tmp;
        // }

        // 扩容 + 定位
        int index = -1;
        for (int i = 0; i < arr1.length; ++i) {
            if (x <= arr1[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            index = arr1.length;
        }

        for(int i = 0, j = 0; i < arr2.length; ++i) {
            if (i != index) {
                arr2[i] = arr1[j++];
            } else {
                arr2[i] = x;
            }
        }

        arr1 = arr2;    // arr1指向arr2
        for (int i = 0; i < arr2.length; ++i) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("");

        // 测试代码输出结果
        char[] arr11 = {'a', 'z', 'b', 'c'};
        char[] arr22 = arr11;
        arr11[2] = '韩';
        for (int i = 0; i < arr22.length; ++i) {
            System.out.println(arr11[i] + ", " + arr22[i]);
        }

        // 冒泡排序：降序
        for (int i = 0; i < arr1.length-1; ++i) {
            for (int j = 0; j < arr1.length-1-i; ++j) {
                if (arr1[j] < arr1[j+1]) {
                    int tmp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < arr2.length; ++i) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("");

        // (int)(Math.random() * 100) + 1;  生成 [1, 100) 的一个随机整数
        int[] arr3 = new int[10];
        for (int i = 0; i < arr3.length; ++i) {
            arr3[i] = (int)(Math.random() * 100) + 1;
        }
        System.out.println("===arr3===");
        for (int i = arr3.length-1; i >= 0; --i) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println("");
    }
}
