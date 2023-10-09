package chapter06;
import java.util.Scanner;
public class Search {
    public static void main(String[] args) {
        // 定义一个字符串数组
        String[] names = {"白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王"};
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String findName = myScanner.next();
        boolean flag = false;
        // 遍历数组，逐一比较，如果有，则提示信息，并退出
        for (int i = 0; i < names.length; ++i) {
            if (findName.equals(names[i])) {
                System.out.println("找到了！" + findName);
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println("没找到！");
        }
    }
}

