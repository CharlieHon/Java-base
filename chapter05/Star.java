package chapter05;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthEditorPaneUI;
public class Star {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int totalLevel = myScanner.nextInt();

        // 半金字塔
        for (int i = 1; i <= totalLevel; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        // 实心金字塔
        for (int i = 1; i <= totalLevel; ++i) {
            for (int j = 1; j <= totalLevel - i; ++j) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; ++j) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        // 空心金字塔
        for (int i = 1; i <= totalLevel; ++i) {
            for (int j = 1; j <= totalLevel - i; ++j) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i - 1; ++j) {
                // 每层的一个和最后一个输出*，最后一层全部输出
                if (j == 1 || j == 2*i - 1 || i == totalLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

        // 空心菱形
        for (int i = 1; i <= totalLevel; ++i) {
            int x = (totalLevel+1)/2;
            if (i <= x) {
                for (int j = 1; j <= x - i; ++j) {
                    System.out.print(" ");
                }
            } else {
                for (int j = 1; j <= i - x; ++j) {
                    System.out.print(" ");
                }
            }

            if (i <= x) {
                for (int j = 1; j <= 2*i - 1; ++j) {
                    if (j == 1 || j == 2*i - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int j = 1; j <= (-2)*i+2*totalLevel+1; ++j) {
                    if (j == 1 || j == (-2)*i+2*totalLevel+1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
