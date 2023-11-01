package customgeneric;

public class CustomGeneric {
    public static void main(String[] args) {
        System.out.println("OK~");
    }
}

// 1. Tiger 后面泛型，吧 Tiger 称为自定义泛型类
// 2. T, R, M 泛型的标识符，一般是大写的单个字母
// 3. 泛型标识符可以有多个
// 4. 普通成员可以使用泛型(属性、方法)
// 5. 使用泛型的数组，不能初始化
// 6. 静态方法不能使用类的泛型
class Tiger<T, R, M> {
    private String name;
    T t;    // 属性泛型
    R r;
    M m;
//    T[] ts = new T[8];  // 不能初始化，因为数组在 new 时，无法确定 T 的类型，就无法在内存开辟空间
    T[] ts; // 可以定义

    public Tiger(String name, T t, R r, M m) {  // 方法泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    // 因为静态是和类相关的，在类加载时，对象还没有创建
    // 所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}