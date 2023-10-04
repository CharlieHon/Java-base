package chapter03;

public class StringToBasic {
    public static void main(String[] args) {
        /** 基本数据类型和String类型的转换
         * - 基本数据类型->String：将基本类型的值 + ""即可
         * - String类型->基本数据类型：通过基本类型的包装类调用parseXX方法即可
         */
        // 基本数据类型->String
        int n1 = 100;
        float f1 = 1.1f;
        double d1 = 3.14;
        boolean b1 = true;
        String s1 = n1 + "";
        String s2 = f1 + "";
        String s3 = d1 + "";
        String s4 = b1 + "";
        System.out.println(s1 + " " + s2 + " " + s3 + " " + s4);    // 100 1.1 3.14 true

        String s5 = "123";
        // 使用基本数据类型对应的包装类的相应方法，得到基本数据类型
        int num1 = Integer.parseInt(s5);
        float num2 = Float.parseFloat(s5);
        double num3 = Double.parseDouble(s5);
        long num4 = Long.parseLong(s5);
        byte num5 = Byte.parseByte(s5);
        // boolean b2 = Boolean.parseBoolean("true");   // 未定义
        short num7 = Short.parseShort(s5);
        System.out.println(num1+1); // 124
        
        // 怎么把字符串转换成字符char -> 把字符串的每个字符
        // s5.charAt(0)：得到s5的第一个字符，下标为0
        System.out.println(s5.charAt(0));   // 1

        /** 注意事项
         * 1. 将String类型转换成基本数据类型时，要确保String类型能够转成有效的数据。
         *      比如，可以把"123"转成一个整数，但是不能把"hello"转成一个整数
         * 2. 如果格式不正确，就会抛出异常，程序就会终止，这个问题在异常处理章节中会处理
         */
        String str = "hello";
        int n2 = Integer.parseInt(str);
        System.out.println(n2); // 编译不报错，执行出错
    }
}
