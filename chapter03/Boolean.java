package chapter03;

public class Boolean {
    public static void main(String[] args) {
        /** 布尔类型：boolean
         * 1. 布尔类型也叫boolean类型，只允许取值true和false，无null
         * 2. boolean类型占1个字节
         * 3. boolean类型适用于逻辑运算，一般用于程序流程控制
         * 4. 不可以用0或非0，代替false或true
         */
        boolean flag = true;
        if(flag == true) {
            System.out.println("考试通过，恭喜！");
        } else {
            System.out.println("再接再厉");
        }
    }
}
