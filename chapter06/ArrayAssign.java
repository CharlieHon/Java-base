package chapter06;

public class ArrayAssign {
    public static void main(String[] args) {
        // 基本数据类型赋值，方式为值拷贝
        int n1 = 10, n2 = n1;
        n2 = 20;    // n2的变化不会影响n1
        System.out.println("n1 = " + n1);   // n1 = 10
        System.out.println("n2 = " + n2);   // n2 = 20
        
        // 数组在默认情况下是引用传递，赋的值是地址，赋值方式为引用传递/地址拷贝
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;  // 把arr1 赋给 arr2
        arr2[0] = 6;    // arr2变化会影响arr1
        System.out.println("arr1[0] = " + arr1[0]); // arr1[0] = 6
    
        // 数组拷贝，要求数据空间是独立的
        int[] arr3 = {10, 20, 30};
        // 创建一个新的数组arr4，开辟新的数据空间，大小 arr3.length
        int[] arr4 = new int[arr3.length];  // 开辟新的空间
        for (int i = 0; i < arr3.length; ++i) {
            arr4[i] = arr3[i];  // 遍历 arr3 把每个元素拷贝到 arr4 对应的位置
        }
        arr4[0] = 66;   // 修改arr4，不会对arr3有影响
        System.out.println(arr3[0]);    // 10
    }
}
