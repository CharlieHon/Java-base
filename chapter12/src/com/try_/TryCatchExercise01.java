package com.try_;

public class TryCatchExercise01 {
    public static int method() {
        try {
            String[] names = new String[3]; // String[] 数组
            if (names[1].equals("tom")) {   // 未赋值，默认为null -> NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "bruce";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {  // 到这
          return 3; // 返回
        } finally { // 但是，必须执行
            return 4;   // 所以返回4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());   // 4
    }
}
