package com.try_;

public class TryCatch01 {
    public static void main(String[] args) {
        // 快捷键：ctrl + alt + t
        // 1. 如果发生了异常，则异常发生后面的代码不会执行，直接进入catch块
        // 2. 如果异常没有发生，则顺序执行 try 代码块，不会进入到 catch
        // 3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)
        // 4. 可以有多个 catch 语句，捕获不同的异常(进行不同的业务处理)，要求父类异常在后，子类异常在前
        //      比如(Exception 在后，NullPointerException在前），如果发生异常，只会匹配一个catch
        //      则使用 -finally{}
        try {
            String str = "bruce";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        } catch (Exception e) {
            System.out.println("异常信息：" + e.getMessage());
        } finally {
            System.out.println("finally代码块执行...");
        }
        System.out.println("程序继续...");
    }
}
