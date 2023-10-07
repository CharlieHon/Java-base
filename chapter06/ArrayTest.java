package chapter06;

public class ArrayTest {
    public static void main(String[] args) {
        // 1. A~Z
        char[] alpha = new char[26];
        for (int i = 0; i < alpha.length; ++i) {
            alpha[i] = (char)('A' + i); // 'A' + i 是 int，需要强制转换为 char类型
        }
        for (int i = 0; i < alpha.length; ++i) {
            System.out.print(alpha[i] + " ");
        }

        // 2. 求数组最大值和对应下标
        int[] a = {4, -1, 9, 10, 23, 11, -5, 888, 76};
        int maxVal = a[0], maxIx = 0;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] > maxVal) {
                maxVal = a[i];
                maxIx = i;
            }
        }
        System.out.println("\na[" + maxIx + "] = " + maxVal);

        // 3. 求数组和和平均值
        double sum = 0., avg = 0.;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
        }
        avg = sum / a.length;
        System.out.println("sum = " + sum + ", avg = " + avg);
    }
}
