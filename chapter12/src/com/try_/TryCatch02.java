package com.try_;

public class TryCatch02 {
    public static void main(String[] args) {
        // 4. 可以有多个 catch 语句，捕获不同的异常(进行不同的业务处理)，要求父类异常在后，子类异常在前
        //      比如(Exception 在后，NullPointerException在前），如果发生异常，只会匹配一个catch
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());   // NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;   // ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常：" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算术异常：" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}

class Person {
    private String name;    // 默认为 null
    public String getName() {
        return name;
    }
}