package set_;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        /*
        1. 在 LinkedHashSet 中维护了一个 hash 表和 双向链表 (LinkedHashSet有head和tail)
        2. 每一个结点有 before 和 after 属性，这样可以形成双向链表
        3. 在添加一个元素时，先求 hash值，再求索引确定该元素再 table 的位置，然后再将添加的元素加入到双向链表
            (如果已存在，不添加，原则和HashSet一样)
            tail.next = newElement;
            newElement.before = tail;
            tail = newElement;
        4. 遍历 LinkedHashSet 也能确保插入顺序和遍历顺序一致
         */
        Set<Object> set = new LinkedHashSet<>();    // LinkedHashSet 的底层是 LinkedHashMap
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");
        System.out.println("set" + set);    // set[AA, 456, Customer{name='刘', id=1001}, 123, HSP]

        // 1. LinkedHashSet 元素的加入顺序和取出顺序一致
        // 2. LinkedHashSet 底层维护的是一个 LinkedHashMap(是HashMap的子类)
        // 3. LinkedHashSet 底层结构 (数组+双向链表)
        // 4. 添加第一次时，直接将 table 扩容到 16 ，存放的结点类型是 LinkedHashMap$Entry
        // 5. 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型
        /*
        // 继承关系是在内部类完成
        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }
         */
    }
}

class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}