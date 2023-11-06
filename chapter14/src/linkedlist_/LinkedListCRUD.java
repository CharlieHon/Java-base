package linkedlist_;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("linkedList=" + linkedList); // linkedList=[1, 2, 3, 4, 5]
        // 演示删除一个结点
        linkedList.remove();    // 默认删除第一个结点，返回删除结点的内容(item)
        linkedList.remove(1);   //  按索引删除
        System.out.println("linkedList=" + linkedList); // linkedList=[2, 4, 5]

        // 修改某个结点对象
        linkedList.set(1, 6);
        System.out.println("linedList=" + linkedList);  // linedList=[2, 6, 5]

        // 得到某个结点对象
        Object o = linkedList.get(2);
        System.out.println(o);  // 5

        // 遍历：因为 LinkedList 实现了 List 接口，可以使用迭代器和增强for循环
        System.out.println("===LinkedList遍历===");
        Iterator<Object> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("===增强for循环===");
        for (Object object : linkedList) {
            System.out.println(object);
        }

        /*  1.   LinkedList<Object> linkedList = new LinkedList<>();
                 public LinkedList() {}
            2. 此时 linkedList 的属性 size = 0 first = null, last = null
            3. 执行添加
            public boolean add(E e) {
                linkLast(e);    // 在尾部进行添加元素
                return true;
            }
            4. 将新的结点，加入到双向链表的最后
            void linkLast(E e) {
                final Node<E> l = last;
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode;
                if (l == null)
                    first = newNode;
                else
                    l.next = newNode;
                size++;
                modCount++;
            }
         */
        // 删除结点 linkedList.remove()
        /*
            1. 执行 removeFirst
            public E remove() {
                return removeFirst();
            }
            2. 执行
            public E removeFirst() {
                final Node<E> f = first;
                if (f == null)
                    throw new NoSuchElementException();
                return unlinkFirst(f);
            }
            3. 执行 unlinkFirst(f) 将 f 指向的双向链表的第一个结点拿掉
            private E unlinkFirst(Node<E> f) {
                // assert f == first && f != null;
                final E element = f.item;   // 返回删除结点的内容(item)
                final Node<E> next = f.next;
                f.item = null;
                f.next = null; // help GC
                first = next;
                if (next == null)
                    last = null;
                else
                    next.prev = null;
                size--;
                modCount++;
                return element;
            }
         */
    }
}
