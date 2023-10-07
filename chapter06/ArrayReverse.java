package chapter06;

public class ArrayReverse {
    public static void main(String[] args) {
        // 定义数组，将数组中元素顺序翻转
        int[] arr1 = {11, 22, 33, 44, 55, 66};
        int tmp = 0, len = arr1.length;
        for (int i = 0, j = len - 1; i < j; ++i, --j) {
            tmp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = tmp;
        }
        for (int i = 0; i < arr1.length; ++i) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("");

        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < len; ++i) {
            arr2[i] = arr1[len-1-i];
        }
        arr1 = arr2;    // 让arr1指向arr2数据空间，arr1原数据空间没有变量引用被回收
        for (int i = 0; i < arr1.length; ++i) {
            System.out.print(arr1[i] + " ");
        }
    }
}
