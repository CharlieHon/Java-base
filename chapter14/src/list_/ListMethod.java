package list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("张三丰");
        list.add("贾宝玉");
        // void add(int index, Object elem): 在index位置插入elem元素
        list.add(1, "李自成");
        System.out.println("list=" + list); // list=[张三丰, 李自成, 贾宝玉]
        // boolean addAll(int index, Collection elems): 从index位置开始将elems中所有元素添加进来
        List<Object> list2 = new ArrayList();
        list2.add("Jack");
        list2.add("Pony");
        list2.add("Pony");
        list.addAll(1, list2);
        System.out.println("list=" + list); // list=[张三丰, Jack, Pony, Pony, 李自成, 贾宝玉]
        // Object get(int index): 获取指定index位置的元素
        // int indexOf(Object obj): 返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("Jack"));   // 1
        // int lastIndexOf(Object obj): 返回obj在集合中最后一次出现的位置
        System.out.println(list.lastIndexOf("Pony"));   // 3
        // Object set(int index, Object elem): 设置指定index位置的元素为elem，相当于替换
        list.set(1, "marry");
        System.out.println("list=" + list); // list=[张三丰, marry, Pony, Pony, 李自成, 贾宝玉]
        // List subList(int fromIndex, int toIndex): 返回从 fromIndex 到 toIndex 位置的子集合
        List<Object> list3 = list.subList(0, 2);    // 前闭后开：[)
        System.out.println("list3=" + list3);   // list3=[张三丰, marry]
    }
}
