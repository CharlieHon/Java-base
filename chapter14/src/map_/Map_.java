package map_;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        // JDK8的 Map接口 特点
        /*
        1. Map 和 Collection 并列存在，用于保存具有映射关系的数据：Key-Value(双列元素)
        2. Map 的 key 和 value 可以是任意引用类型的数据，会封装到 HashMap$Node 对象中
        3. Map 中的 key 不允许重复，原因和 HashSet 一样
        4. Map 中的 value 可以重复
        5. Map 中的 key 可以为 null，value 可以为 null。key 为 null 的只能有一个，value为null可以有多个
        6. 常用 String 作为 Map 的 key
        7. key 和 value 存在单向一对一关系，即通过指定key总能找到对应的value
        8. Map 存放数据的 key-value，一对 k-v 是放在一个 Node 中的，又因为 Node 实现了 Entry接口，
            也说一对 k-v 就是一个 Entry
         */
        Map<Object, Object> map = new HashMap<>();
        map.put("no1", "韩顺平");
        map.put("no2", "张无忌");
        map.put("no1", "张三丰");  // 当有相同的 key，就等价于替换value
        map.put("no3", "张三丰");  // 当有相同的 key，就等价于替换value
        map.put(null, null);
        map.put(null, "abc");   // 替换上面的value
        map.put("no4", null);
        map.put("no5", null);
        System.out.println("map=" + map);
        // 通过 get() 方法，传入 key ，会返回对应的 value
        System.out.println(map.get("no2")); // 张无忌
    }
}
