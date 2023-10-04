package chapter03;

public class intDetail {
    public static void main(String[] args) {
        // 整数类型
        // 1.Java各整数类型有固定的范围和字段长度，不受具体OS的影响，以保证java程序的可移植性
        // 2.Java的整型常量默认是int型，声明long型常量须在后加 'l' 或 'L'
        // 3.Java程序中变量常声明为int型，除非不足以表示大树，才使用long
        int a = 100;
        long b = 1314l; // long型字面值
        // int c = 100l;   // 错误：无法从long转换到int
        long d = 123;
    }
}