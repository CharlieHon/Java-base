/** 文档注释：注释内容可以被JDK提供的工具javadoc所解析，生成一套网页文件形式体现在的该程序的说明文档
 * @author  Charlie
 * @version 1.0
 * 以@开头的是javadoc标签
 * javadoc -d 目录 -xx -yy 文件名
 */
public class Comment {
    // 编写一个main方法
    public static void main(String[] args){
        // 注释
        /*
         * 多行注释，不允许再嵌套多行注释
         */
        int n1 = 10;
        int n2 = 30;
        // 求和
        int sum = n1 + n2;
        // 输出结果
        System.out.println("sum = " + sum);
    }
}
