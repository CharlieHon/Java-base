package vector_;

import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
       Vector<Object> vector = new  Vector<Object>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        // 1. new Vector<>();
        /*
        public Vector() {
            this(10);
        }
         */
        // 2. vector.add(i)
        /*
        public synchronized boolean add(E e) {
            modCount++;
            ensureCapacityHelper(elementCount + 1); // 2.1 判断是否需要扩容
            elementData[elementCount++] = e;
            return true;
        }
        // 2.2 确定是否需要扩容，条件需要的容量 minCapacity 比 实际 elementData 数组长度要大
        private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
                grow(minCapacity);
        }
        // 2.3 如果需要的数组大小不够用，就会扩容，扩容的算法如下
        private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = elementData.length;
            // 如果 capacityIncrement 不大于 0，就扩容两倍
            // this(initialCapacity, capacityIncrement: 0); // capacityIncrement默认为0
            int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                             capacityIncrement : oldCapacity);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
         */

    }
}
