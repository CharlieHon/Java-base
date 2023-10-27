package com.try_;

public class TryCatchExercise03 {
    public static int method() {
        int i = 1;
        try {
            i++;    // i = 2
            String[] names = new String[3]; // String[] 数组
            if (names[1].equals("tom")) {   // 未赋值，默认为null -> NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "bruce";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; // i = 3 => tmp = 3 保存临时变量，执行完finally后返回临时变量
        } finally { // 必须执行
            ++i;    // 4
            System.out.println("i=" + i);   // i=4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
        /*
        i=4 // finally输出
        3   // method()方法返回
         */
    }
}
