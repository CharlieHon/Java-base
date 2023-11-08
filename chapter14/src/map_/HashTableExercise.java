package map_;

import java.util.Hashtable;

public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("tom", 100);
//        table.put(null, 100);   // 异常 NullPointerException
//        table.put("tom", null); // 同上
        table.put("bruce", 100);
        table.put("bruce", 200);
        table.put("ming", 200);
        table.put("hello", 200);
        table.put("hello1", 200);
        table.put("hello2", 200);
        table.put("hello3", 200);
        table.put("hello4", 200);
        table.put("hello5", 200);
        System.out.println("table=" + table);   // table={tom=100, bruce=200}
        // HashTable底层源码分析
        /*
        1. 底层有数组 HashTable$Entry 初始化大小为11
        2. threshold 8 = 11 * 0.75
        3. 扩容：
        4. 执行方法 addEntry(hash, key, value, index); 添加 K-V 进行扩容
        5. 当 if (count >= threshold) 满足时，就进行扩容。扩容方式如下：
                int newCapacity = (oldCapacity << 1) + 1;   //
         */
    }
}
