package set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        // Set接口基本介绍
        /*
        1. 无序（添加和取出的顺序不一致），没有索引
        2. 不允许重复元素，所以最多包含一个 null
        3. JDK API中 Set 接口的实现类有 HashSet, TreeSet
         */
        // Set 接口的遍历方式
        /*
        同 Collection 的遍历方式一样，因为 Set 接口是 Collection 接口的子接口
        1. 可以使用迭代器
        2. 增强 for
        3. 不能使用索引的方式来获取
         */

        // 以 HashSet 为例，演示
        // 1. set 接口实现类的对象，不能存放重复的元素，可以添加一个 null
        // 2. set 几口对象存放数据是无序的(即添加的顺序和取出的顺序不一致)，但是是固定的(不是随机的存取)
        // 3. 取出的顺序虽然不是添加的顺序，但是是固定的
        Set<Object> set = new HashSet<>();
        set.add("john");
        set.add("charlie");
        set.add("john");
        set.add("marry");
        set.add("tom");
        set.add(null);
        set.add(null);
        System.out.println("set=" + set);   // set=[null, tom, marry, john, charlie]

        set.remove(null);   // 只能删除指定对象

        // 遍历
        // 方式1：使用迭代器
        System.out.println("===迭代器===");
        Iterator<Object> iter = set.iterator();
        while (iter.hasNext()) {
            Object next = iter.next();
            System.out.println(next);
        }
        // 方式2：增强for循环(底层就是迭代器)
        System.out.println("===增强for循环===");
        for (Object o : set) {
            System.out.println(o);
        }
        // set 接口对象，不能使用索引获取元素
    }
}
