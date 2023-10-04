// 演示转义字符的使用
public class ChangeChar {
    // 编写一个main方法
    public static void main(String[] args){
        // \t：制表位，实现对其的功能
        System.out.println("北京\t天津\t上海\n");
        // \n：换行符
        // \\：输出一个 \
        System.out.println("Hello\\, World!");
        // \"：输出一个"
        System.out.println("Hello, \"你好\"");
        // \'：输出一个'
        // \r：一个回车
        System.out.println("韩顺平教育\r北京"); // 北京平教育
        System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000");
    }
}
