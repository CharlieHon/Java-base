package chapter07;

public class Method02 {
    public static void main(String[] args) {
        // 遍历一个数组，输出数组的各个元素值
        int[][] map = {{0, 0, 1}, {1, 1, 1}, {3, 3, 4}};
        // 直接遍历
        // for (int i = 0; i < map.length; ++i) {
        //     for (int j = 0; j < map[i].length; ++j) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        // 使用方法完成输出
        MyTools myTool = new MyTools();
        myTool.printArr(map);

    }
}

// 把输出功能写到一个类的方法中，提高代码复用性；将实现细节封装起来，然后供其他用户来调用
class MyTools {
    /** 成员方法的定义
     * public 返回数据类型 方法名(形参列表) {
     *      // 方法体
     *      return; // 不是必须的
     * }
     */
    // 方法，接收一个二维数组
    public void printArr(int[][] map) {
        System.out.println("=====");
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}