package customgeneric;

public class Exercise {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);  // 10 会被自动装箱 Integer
        apple.fly(new Dog());   // Dog
    }
}

class Apple<T, R, M> {  // 自定义泛型类
    public<E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }
//    public void eat(U u) {}   // 使用泛型的方法，但是该泛型未在类中声明
    public void run(M m) {}
}

class Dog {}