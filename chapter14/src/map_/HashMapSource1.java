package map_;

import java.util.HashMap;

public class HashMapSource1 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);
        map.put("cpp", 10);
        map.put("java", 20);

        System.out.println("map=" + map);
        // HashMap源码解读
        /*
        // 1. 执行构造器 new HashMap()
        public HashMap() {
            // 初始化加载因子 loadfactor = 0.75
            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
            // HashMap$Node[] table = null;
        }
        // 2. 执行 put 调用 hash 方法，计算 key 的hash值
        public V put(K key, V value) {  // kay = "java" value = 10
            return putVal(hash(key), key, value, false, true);
        }
        // 3. 执行 putVal 方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                       boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;
            // 如果底层的 table 数组为null，或者 length=0，就扩容到 16
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            // 根据hash值对应的table的索引位置的Node，如果为null，就直接加入k-v
            // 创建一个Node，加入该位置即可
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {  // 新加元素的hash值位置索引处有内容
                Node<K,V> e; K k;
                 // 如果table索引位置的key的hash值和新加元素的相同，
                 // 并且现有key和新加key是同一对象 || key.equals()返回真，则不添加
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof TreeNode) // 当前已有 Node 是一个红黑树，则按红黑树的方式添加
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    // 如果找到的结点，后面是链表，就循环比较
                    for (int binCount = 0; ; ++binCount) {  // 死循环
                        if ((e = p.next) == null) { // 如果整个链表，没有和他相同的，就加到该链表的最后
                            p.next = newNode(hash, key, value, null);
                            // 加入后，判断当前链表的个数是否已经达到8个，达到或就进行树化
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        // 如果在循环比较过程中，发现有相同的，就break
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;    // 只是替换 value 的内容
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount; // 每增加一个Node，就size++
            if (++size > threshold)
                resize();   // 如果 size 大于临界值，就扩容
            afterNodeInsertion(evict);
            return null;
        }
         */
    }
}
