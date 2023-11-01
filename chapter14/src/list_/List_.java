package list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        // 1. List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复
        List<Object> list = new ArrayList<>();
        list.add("Tao");
        list.add("Tom");
        list.add("John");
        list.add("Tom");
        System.out.println("list=" + list);
        // 2. List集合中每个元素都有其对应的顺序索引，即支持索引。索引从0开始
        // 3. List容器中的每个元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
        System.out.println(list.get(0));    // Tao
        // 4. JDK API中List接口的实现类有很多，常用的是：ArrayList, LinkedList, Vetcor
    }
}
