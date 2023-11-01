package customgeneric;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

// 泛型接口使用注意事项
// 1. 接口中，静态成员也不能使用泛型
// 2. 泛型接口的类型，是在 继承接口 或者 实现接口 时确定的
// 3. 没有指定类型时，默认为 Object
interface IUsb<U, R> {

    int n = 10;
//    U name = "bruce";   // 错误：接口中所有属性都是 static 的

    // 普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    // 在 jdk8 中，可以在接口中，使用默认方法
    default R method(U u) {
        return null;
    }
}
// 在继承接口时，指定泛型接口的类型
interface IA extends IUsb<String, Double> {}
class AA implements IA {    // 当实现IA接口时，因为IA在继承IUsb接口时，指定了U为String、R为Double

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}
// 在实现接口时，直接指定泛型接口的类型。将U指定为Integer，R指定为Float
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
// 没有指定类型
class CC implements IUsb {  // 等价于 class CC implements IUsb<Object, Object, Object> {}
    @Override
    public Object get(Object object) {
        return null;
    }

    @Override
    public void hi(Object object) {}

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {}
}