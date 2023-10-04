package chapter03;

public class Var {
    // 编写一个main
    public static void main(String[] args) {
        // 声明变量
        int a;
        a = 100;
        System.out.println(a);
        // 初始化
        int b = 800;
        System.out.println(b);
        // 记录人的信息
        int age = 21;
        double score = 88.9;
        char gender = '男';
        String name = "Charlie";
        // 输出信息
        System.out.println("人的基本信息如下：");
        System.out.println(name);
        System.out.println(gender);
        System.out.println(age);
        System.out.println(score);
        // 变量必须先声明，后使用
        a = 66; // 该区域的数据/值可以在同一类型范围内不断变化
        System.out.println(a);
        // 变量在同一个作用域内不能重名
        // int a = 77; // 错误
        
    }
}
