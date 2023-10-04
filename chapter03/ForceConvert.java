package chapter03;
public class ForceConvert {
    public static void main(String[] args) {
        /** 强制类型转换
         * 自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。
         * 使用时要加上强制转换符()，但可能造成精度降低或溢出，格外要注意
         */
        int i = (int)1.9;
        System.out.println(i);  // 1    1.造成精度损失

        int j = 1000;
        byte b1 = (byte)j;
        System.out.println("b1=" + b1); // b1=-24   2.溢出

        /** 强制类型转换细节说明
         * 1. 当进行数据的大小从 大——>小，就需要使用到强制转换
         * 2. 强制符号只针对于最近的操作有效，往往会使用小括号提升优先级
         * 3. char类型可以保存int的常量值，但不能保存int的变量值，需要强转
         * 4. byte,char和short类型在进行运算时，当作int类型处理
         */
        // int x = (int)10*3.5+6*1.5;  // 错误：仅将10转换为int，最终结果仍是double [1]
        int x = (int)(10*3.5+6*1.5);    // (int)44.0
        System.out.println(x);  // 44

        char c1 = 100;
        int m = 100;
        // char c2 = m;    // 错误
        char c3 = (char)m;
        System.out.println(c3); // d

    }
}