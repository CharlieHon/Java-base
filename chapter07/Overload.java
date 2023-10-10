package chapter07;

public class Overload {
    public static void main(String[] args) {
        /** 方法重载(Overload)
         * - Java中允许同一个类中，多个同名方法的存在，但要求形参列表不一致
         * - 方法名必须相同；形参列表必须不同(形参类型，或者个数，或者顺序)
         *      仅返回类型不同不能构成重载
         */
        System.out.println(100);
        System.out.println(100);
        MyCalculate mc = new MyCalculate();
        System.out.println(mc.calculate(1.1, 0));   // 1.1
        System.out.println(mc.calculate(1, 3)); // 4
        System.out.println(mc.calculate(1, 7, 9));  // 17
    }
}

class MyCalculate {
    // 下面的四个 calculate 方法构成了重载
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }
    public double calculate(int n1, double d1) {
        return n1 + d1;
    }
    public double calculate(double d1, int n1) {
        return d1 + n1;
    }
    public int calculate(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}