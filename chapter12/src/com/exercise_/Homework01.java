package com.exercise_;

public class Homework01 {
    public static void main(String[] args) {

        try {
            // 先验证输入的参数的个数是否正确，两个参数
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            // 把接收到的参数，转成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2);
            System.out.println("n1 / n2 = " + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输入整数");
        } catch (ArithmeticException e) {
            System.out.println("出现除0异常");
        }
        System.out.println("OK~");  // 因为已经捕获异常，异常已经被处理，所以程序不会退出，继续执行输出 OK~
    }

    public static double cal(int n1, int n2) {
        return n1/ n2;
    }
}