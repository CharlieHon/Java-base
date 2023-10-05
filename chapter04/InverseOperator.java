package chapter04;

public class InverseOperator {
    public static void main(String[] args) {
        /** 
         * !取反：真变假，假变真
         * ^逻辑异或：a^b，当a和b不同时，结果为true，否则为false
         */
        System.out.println(60 > 20);    // true
        System.out.println(!(60 > 20)); // false

        boolean a = (10 > 3) ^ (1 < 5);
        boolean b = (5 > 3) ^ (6 < 2);
        System.out.println("a = " + a + ", b = " + b);  // a = false, b = true
    }
}
