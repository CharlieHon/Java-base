package chapter06;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        /** 二维数组
         * - 从定义形式上看 int[][]
         * - 一维数组的每个元素是一维数组，就构成二维数组
         * 二维数组的使用
         * 1. 初始化
         *  动态初始化：类型名[][] 数组名 = new 类型[大小][大小];   int[][] a = new int[2][3];
         *  静态初始化：类型[][] 数组名 = {{值1,值2..}, {值1,值2..}, {值1,值2..}};
         * 2. 二维数组在内存的存在形式
         * 3. Java语言允许二维数组的列数不同，即每个一个数组元素长度不同
         *  
         */
        int[][] arr = {{0,0,0,0,0},{0,0,1,0,0},{0,2,0,3,0},{0,0,0,0,0}};
        int[][] arr1 = new int[2][3];
        int arr2[][];
        arr2 = new int[3][4];   // 先声明再定义
        for (int i = 0; i < arr1.length; ++i) {
            // 遍历二维数组的每个元素(数组)
            // arr[i].length 得到对应每个一维数组的长度
            for (int j = 0; j < arr1[i].length; ++j) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println("");
        }

        // 动态创建数组
        int[][] arr3 = new int[3][];    // 创建二维数组，但是只是确定一维数组的个数
        for (int i = 0; i < arr3.length; ++i) { // 遍历 arr3 每个一维数组
            // 给每个一维数组开空间 new
            // 如果没有给一维数组 new，那么arr3[i] 就是 null
            arr3[i] = new int[i+1];
            // 遍历一维数组，并给每个一维数组的每个元素赋值
            for (int j = 0; j < arr3[i].length; ++j) {
                arr3[i][j] = j + 1;
            }
        }

        // 遍历
        System.out.println("=====");
        for (int i = 0; i < arr3.length; ++i) {
            for (int j = 0; j < arr3[i].length; ++j) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println("");
        }

        // 打印10行的杨辉三角
        int[][] arr4 = new int[10][];
        for (int i = 0; i < arr4.length; ++i) {
            arr4[i] = new int[i+1]; // 为每个数组元素开辟空间
            for (int j = 0; j < arr4[i].length; ++j) {
                if (j == 0 || j == i) {
                    arr4[i][j] = 1;
                } else {
                    arr4[i][j] = arr4[i-1][j-1] + arr4[i-1][j];
                }
            }
        }
        System.out.println("---杨辉三角---");
        for (int i = 0; i < arr4.length; ++i) {
            for (int j = 0; j < arr4[i].length; ++j) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println("");
        }
        
        // 练习
        int[] x, y[];   // x是一维数组，y是int类型的二维数组
    }
}
