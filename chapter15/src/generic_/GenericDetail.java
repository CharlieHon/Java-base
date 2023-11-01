package generic_;

import java.util.ArrayList;
import java.util.List;

public class GenericDetail {
    public static void main(String[] args) {
        // 1. 泛型类型 T, E 只能是引用类型
        List<Integer> list = new ArrayList<Integer>();
//        List<int> list1 = new ArrayList<int>();  // 错误：Type argument cannot be of primitive type
        // 2. 在给泛型指定具体类型后，可以传入该类型或者其子类类型
        Pig<A> aPig = new Pig<A>(new A());
        aPig.show();    // class generic_.A
        Pig<A> bPig = new Pig<A>(new B());
        bPig.show();    // class generic_.B
        // 3. 泛型使用形似和
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        // 在实际开发中，往往简写
        // 编译器会进行类型推断，推荐使用写法
        ArrayList<Integer> list2 = new ArrayList<>();
        // 4. 如果不显示指定 T, E 默认为 Object 类型
        List list3 = new ArrayList();   // 等价于 List<Object> list3 = new ArrayList<>();
        Tiger tiger = new Tiger();
//        Tiger<Object> objectTiger = new Tiger<>();    // 与上等价
    }
}

class A {}
class B extends A {}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void show() {
        System.out.println(e.getClass());
    }
}
class Tiger<E> {
    E e;
    public Tiger(){}
}