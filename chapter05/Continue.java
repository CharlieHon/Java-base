package chapter05;

public class Continue {
    public static void main(String[] args) {
        /** Continue退出本次循环，执行下一次循环
         * 
         */
        // int i = 1;
        // while(i <= 4) {
        //     ++i;
        //     if (i == 2) continue;
        //     System.out.println("i = " + i);
        // }

        label1:
        for (int i = 0; i < 2; ++i) {
            label2:
            for (int j = 0; j < 4; ++j) {
                if (j == 2) {
                    // continue;   // 等价于 continue label2
                    continue label1;
                }
                System.out.print("j = " + j + " ");
            }
            System.out.print("\n");
        }
    }
}
