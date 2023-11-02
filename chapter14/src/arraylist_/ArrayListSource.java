package arraylist_;

import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        // 1. ArrayList中维护了一个 Object 类型的数组 elementData
        // 2. 当创建 ArrayList 对象时，如果使用的是无参构造器，则初始 elementData容量为0，第一次添加，
        //      则扩容 elementData 为10，如需要再次扩容，则扩容 elementData 为 1.5 倍
        // 3. 如果使用的是指定大小的构造器，则初始化 elementData 容量为指定大小，如果需要扩容，则直接
        //      扩容 elementData 为 1.5 倍
        ArrayList<Object> arrayList = new ArrayList<>();    // 使用无参构造器创建对象
//        ArrayList<Object> arrayList = new ArrayList<>(8);    // 指定大小构造器
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);
    }
}
