package chapter04;

public class LogicOperator {
    public static void main(String[] args) {
        /** 逻辑运算符
         * &&短路 &逻辑与
         * &&只有当第一个条件为true时，才会判断第二个条件
         * &对两个条件都会进行判断，即使第一个为false
         * 
         * 短路或|| 逻辑或|
         * 短路或||当第一个条件为true时，不会判断第二个条件，效率高
         */
        // 短路与&&
        int age = 50;
        if (age > 20 && age < 90) {
            System.out.println("ok100");    // ok100
        }

        // 区别
        int a = 4, b = 9;
        if (a < 1 && ++b < 50) {
            System.out.println("ok200");
        }
        System.out.println("a = " + a + ", b = " + b);  // a = 5, b = 9

        if (a < 1 & ++b < 50) {
            System.out.println("ok200");
        }
        System.out.println("a = " + a + ", b = " + b);  // a = 5, b = 10

        if (a < 10 & ++b < 50) {
            System.out.println("ok300");
        }
        System.out.println("a = " + a + ", b = " + b);  // a = 5, b = 11

        if (a > 1 || ++b < 50) {
            System.out.println("ok400");
        }
        System.out.println("a = " + a + ", b = " + b);  // a = 5, b = 11

        if (a > 1 | ++b < 50) {
            System.out.println("ok500");
        }
        System.out.println("a = " + a + ", b = " + b);  // a = 5, b = 12
    }
}
