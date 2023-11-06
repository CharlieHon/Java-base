package set_;

import java.util.HashSet;
import java.util.Set;

public class HashSet01 {
    public static void main(String[] args) {
        // HashSet的全面说明
        /*
        1. HashSet 实现了 Set 接口
        2. HashSet 的底层，源码如下
            public HashSet() {
                map = new HashMap<>();
            }
        3. 可以存放 null 值，但是只能放一个 null，即元素不能重复
        4. HashSet 不保证元素是有序的，取决于 hash 后，再确定索引的结果(即，不保证存放元素的顺序和取出顺序一致)
        5. 不能有重复元素/对象
         */
        Set<Object> set = new HashSet<>();
        set.add(null);
        set.add("tom");
        set.add("lucy");
        System.out.println(set.add(null));  // 添加元素时会返回一个 boolean值，添加失败返回 false
        System.out.println("set=" + set);   // set=[null]

        // 5. HashSet 不能添加相同的元素/数据？
        set.add("Bruce");
        set.add("Bruce");   // 加入不了
        set.add(new Dog("tom"));    // OK
        set.add(new Dog("tom"));    // OK
        System.out.println("set=" + set);   // set=[null, Bruce, tom, Dog{name='tom'}, Dog{name='tom'}, lucy]

        // 经典
        // 需要看源码，即 add 到底发生了什么
        set.add(new String("hsp")); // OK
        set.add(new String("hsp")); // 加入不了
        System.out.println("set=" + set);   // set=[null, Bruce, tom, hsp, Dog{name='tom'}, Dog{name='tom'}, lucy]
    }
}

class Dog { // 定义一个Dog类
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}