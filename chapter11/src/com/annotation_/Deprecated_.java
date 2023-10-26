package com.annotation_;

public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

// 1. @Deprecated 修饰某个元素，表示该元素已经过时
// 2. 过时表示不推荐使用，但是仍然可以使用
// 3. @Deprecated 原码
// 4. 可以修饰方法，类，字段，包，参数等等
// 5. @Deprecated 可以做版本升级过度使用
/*
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
 */
@Deprecated
class A {
    public int n1 = 10;
    @Deprecated
    public void hi() {
        System.out.println("你好~");
    }
}