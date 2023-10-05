package chapter04;

public class BinaryTest {
    public static void main(String[] args) {
        int n1 = 0b1010;    // 二进制以 0b 或 0B 开头
        int n2 = 1010;
        int n3 = 01010;     // 八进制以 0 开头
        int n4 = 0xffffffff;    // 十六进制以 0x 开头
        System.out.println("n1 = " + n1);   // 10
        System.out.println("n2 = " + n2);   // 1010
        System.out.println("n3 = " + n3);   // 520
        System.out.println("n4 = " + n4);   // -1
    }
}
