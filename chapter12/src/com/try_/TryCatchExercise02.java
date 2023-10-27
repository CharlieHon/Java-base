package com.try_;

public class TryCatchExercise02 {
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
            return ++i; // i = 3    执行，但是不返回
        } finally { // 必须执行
            return ++i; // i = 4    执行，并返回
        }
    }

    public static void main(String[] args) {
        System.out.println(method());   // 4
    }
}
