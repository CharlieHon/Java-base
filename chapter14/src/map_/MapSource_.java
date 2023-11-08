package map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource_ {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("no1", "韩顺平");
        map.put("no2", "张无忌");
        System.out.println("map=" + map);
        /*
        1. k-v 最后放在 HashMap$Node node = newNode(hash, key, value, null)
        2. k-v 为了方便遍历，还会创建 EntrySet 集合，该集合存放的元素的类型是 Entry，而一个
                Entry对象就有 k,v   EntrySet<Entry<k, v>> 即：transient Set<Map.Entry<K,V>> entrySet;
        3. 在 entrySet 中，定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node
            因为 HashMap$Node implements Map.Entry
        4. 当把 HashMap$Node 对象存放到 entrySet 就方便遍历，因为 Map.Entry 提供了重要方法
            K getKey(); K getValue();
         */

        Set<Map.Entry<Object, Object>> set = map.entrySet();
        System.out.println(set.getClass()); // HashMap$EntrySet HashMap的一个内部类
        for (Object obj :
                set) {
//            System.out.println(entry.getClass());
            // 为了从 HashMap$Node 取出 k-v
            // 1. 先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        // 可以分别取出map的key和value的集合
        Set<Object> set1 = map.keySet();
        System.out.println(set1.getClass());    // class java.util.HashMap$KeySet
        Collection<Object> values = map.values();
        System.out.println(values.getClass());  // class java.util.HashMap$Values
    }
}
