package chapter07;

public class Recursion01 {
    public static void main(String[] args) {
        /** 方法递归调用
         * 1. 执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
         * 2. 方法的局部变量是独立的，不会相互影响
         * 3. 如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据
         * 4. 递归必须向退出递归的条件逼近，否则就是无限递归，出现 StackOverflowError
         * 5. 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将
         *      结果放回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕
         */
        T t1 = new T();
        t1.test(4);
        System.out.println("5! = " + t1.factorial(5));  // 5! = 120
        System.out.println("fibonacci(20) = " + t1.fibonacci(20));
        System.out.println("fibo(20) = " + t1.fibo(20));
    }
}

class T {
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibo(int n) {
        int a = 0, b = 1, tmp;
        for (int i = 1; i < n; ++i) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }
}
