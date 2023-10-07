package chapter07;

public class MethodDetail {
    public static void main(String[] args) {
        /** 注意事项
         * 1. 访问修饰符：控制方法使用的范围
         *  如果不写即默认方法；有四种 public protected, private, 默认
         * 2. 返回数据类型
         *  - 一个方法最多有一个返回值
         *  - 返回类型可以为任意类型，包含基本类型或引用类型(数组、对象)
         *  - 如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return 值；
         *      而且要求返回值类型必须和return的值类型一致或兼容
         *  - 如果方法是 void ，则方法体中可以没有return语句，或者只写 return;
         *  - 方法名，应遵循驼峰命名法
         * 3. 参数列表
         *  - 一个方法可以有0个或多个参数，中间用逗号哥开
         *  - 参数类型可以是任意类型，包含基本类型或引用类型，比如 printArr(int[][] map)
         *  - 方法定义时的参数称为形式参数，简称形参；调用时的参数称为实际参数，简称实参
         *      形参和实参的类型要一致或兼容，个数、顺序必须一致
         *  - 方法不能嵌套定义
         */

        AA a = new AA();
        int[] res1 = a.getSumAndSub(5, 8);
        System.out.println(res1[0] + ", " + res1[1]);   // 13, -3
        a.f1();

        byte b1 = 3, b2 = 4;
        int[] res2 = a.getSumAndSub(b1, b2);    // byte -> int
        // a.getSumAndSub(1.1, 2.1);   // double -> int(X)

        
        a.print(3, 2, 'a');
    }
}

class AA {
    // 1. 一个方法最多有一个返回值，返回多个值时，可以以数组形式放回
    public int[] getSumAndSub(int n1, int n2) {
        int[] res = new int[2];
        res[0] = n1 + n2;
        res[1] = n1 - n2;
        return res;
    }

    public void f1() {
        System.out.println("你好~");
        return;
    }

    // 判断一个数是奇数odd还是偶数even
    public boolean isOdd(int x) {
        // if (x % 2 == 0) return false;
        // else return true;
        return x % 2 != 0;
    }

    // 根据行列打印字符
    public void print(int row, int col, char c) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }
}
