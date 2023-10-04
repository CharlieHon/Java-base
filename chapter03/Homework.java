package chapter03;

public class Homework {
    public static void main(String[] args) {
        // 01
        int n1;
        n1 = 13;
        int n2;
        n2 = 17;
        int n3;
        n3 = n1 + n2;
        System.out.println("n3 = " + n3); // n3 = 30
        int n4 = 38;
        int n5 = n4 - n3;
        System.out.println("n5 = " + n5);   // n5 = 8

        // 02
        char c1 = '\n';
        char c2 = '\t';
        char c3 = '\r';
        char c4 = '\\';
        char c5 = '1';

        // 03
        String s1 = "黄帝内经";
        String s2 = "庄子";
        System.out.println(s1 + s2);    // 黄帝内经庄子
        char cr1 = '男';
        char cr2 = '女';
        System.out.println(cr1 + cr2);  // 52906    !：char类型相加的结果是int型数据
        int p1 = 32;
        int p2 = 28;
        System.out.println(p1 + p2);    // 60

        // 04
        String name = "庄周";
        int age = 28;
        double score = 96.;
        char gender = '男';
        String job = "打篮球";
        // "\t"也可以
        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + name + '\t' + age + '\t' + 
            score + '\t' + gender + '\t' + job);
    }
}
