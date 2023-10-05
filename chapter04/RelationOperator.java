package chapter04;

public class RelationOperator {
    public static void main(String[] args) {
        int a = 9, b = 8;
        System.out.println(a > b);  // true
        System.out.println(a >= b);
        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);
        boolean flag = a > b;
        System.out.println("flag = " + flag);
    }
}
