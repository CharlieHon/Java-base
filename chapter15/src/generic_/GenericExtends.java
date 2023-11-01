package generic_;

import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {
        Object obj = new String("Bruce");
        // 泛型没有继承性
//        List<Object> list = new ArrayList<String>(); // 错误
        // 通配符
//        // 说明：List<?> 表示 任意的泛型类型都可以接受
//        public static void printCollection1(List<?> c) {
//            for (Object object :
//                    c) {
//                System.out.println(object);
//            }
//        }
//        // List<? extends AA> 表示 上限，可以接受 AA或者AA的子类
//        public static void printCollection2(List<? extends AA> c) {
//            for (Object object :
//                    c) {
//                System.out.println(object);
//            }
//        }
//        // List<? super AA> 表示 下限，可以接受 AA或者AA的父类，不限于直接父类
//        public static void printCollection3(List<? super AA> c) {
//            for (Object object :
//                    c) {
//                System.out.println(object);
//            }
//        }
    }
}

class AA {}
class BB extends AA {}
class CC extends BB {}