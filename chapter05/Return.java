package chapter05;

public class Return {
    public static void main(String[] args) {
        // return使用在方法，表示跳出所在方法
        // 如果 return 写在 main 方法中，退出程序...
        for (int i = 1; i <= 5; ++i) {
            if (i == 3) {
                System.out.println("Hello, world! " + i);
                return; // 当return用在方法时，表示跳出方法；如果在main中，表示退出程序
                // break;  // 退出循环，仍会执行循环后的程序
                // continue;   // 结束当前循环，执行下一次循环
            }
            System.out.println("Hi~" + i);
        }
        System.out.println("go on...");
    }
}
