package chapter07;

import java.util.Random;
import java.util.Scanner;

public class MoraGame {
    public static void main(String[] args) {
        // 创建一个玩家对象
        Tom t = new Tom();
        int isWinCount = 0; // 记录最后赢得次数
        // 创建一个二维数组，用来接收局数，Tome出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;
        // 创建一个一维数组，用来接收输赢情况
        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            System.out.println("请输入你要出得拳(0-拳头，1-剪刀，2-布)");
            int num = scanner.nextInt();
            t.setTomNum(num);
            int tomGuess = t.getTomNum();
            arr1[i][j+1] = tomGuess;

            // 获取电脑出的拳
            int comGuess = t.computerNum();
            arr1[i][j+2] = comGuess;

            // 将玩家猜的拳与电脑作比较
            String isWin = t.vsComputer();
            arr2[i] = isWin;
            arr1[i][j] = t.count;

            // 对每一局的情况进行输出
            System.out.println("=========================================");                           
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");                                             
            System.out.println(t.count + "\t" + tomGuess + "\t\t" + comGuess + "\t\t" + t.vsComputer());
            System.out.println("=========================================");                          
            System.out.println("\n\n");                                                               
            isWinCount = t.winCount(isWin);   
        }

        // 对游戏的最终结果进行输出                                                                               
        System.out.println("局数\t玩家的出拳\t电脑的出拳\t\t输赢情况");                                               
        for (int a = 0; a < arr1.length; a++) {                                                       
            for (int b = 0; b < arr1[a].length; b++) {                                                
                System.out.print(arr1[a][b] + "\t\t\t");                                              
            }                                                                                         
            
            System.out.print(arr2[a]);                                                                
            System.out.println();                                                                     
        }                                                                                             
        System.out.println("你赢了" + isWinCount + "次");   
    }
}

// Tom类
class Tom {
    int tomNum;     // 玩家出拳类型
    int comNum;     // 电脑出拳类型
    int winCount;   // 玩家赢的次数
    int count = 1;  // 比赛次数，一共三次比赛

    // 电脑随机生成猜拳的数字的方法
    public int computerNum() {
        Random r = new Random();
        comNum = r.nextInt(3);  // 方法：返回0~2的随机数
        return comNum;
    }

    // 设置玩家猜拳的数字的方法
    public void setTomNum(int tomNum) {
        if (tomNum > 2 || tomNum < 0) 
            throw new IllegalArgumentException("数字输入错误");
        this.tomNum = tomNum;
    }

    public int getTomNum() {
        return tomNum;
    }

    // 比较猜拳的结果
    public String vsComputer() {
        if (tomNum == 0 && comNum == 1) {                                                   
            return "你赢了";                                                                             
        } else if (tomNum == 1 && comNum == 2) {                                            
            return "你赢了";                                                                             
        } else if (tomNum == 2 && comNum == 0) {                                            
            return "你赢了";                                                                             
        } else if (tomNum == comNum){                                                       
            return "平手";                                                                              
        } else {                                                                                      
            return "你输了";                                                                             
        } 
    }

    // 记录玩家赢的次数
    public int winCount(String s) {
        ++count;    // 控制玩的次数
        if (s.equals("你赢了")) {
            ++winCount;
        }
        return winCount;
    }
}