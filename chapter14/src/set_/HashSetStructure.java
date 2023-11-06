package set_;

import java.util.HashSet;
import java.util.Set;

public class HashSetStructure {
    public static void main(String[] args) {
        // HashSet 底层机制说明
        // HashSet 底层是 HashMap，HashMap底层是(数组+链表+红黑树)
//        Set<Object> set = new HashSet<>();
        // 1. 创建一个数组，数组的类型是 Node[]
        // 2. 有些人直接将 Node[] 称为表
        Node[] table = new Node[16];
        // 3. 创建结点
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;   // 将 jack 结点挂载到 john 后
        Node rose = new Node("rose", null);
        jack.next = rose;   // 将 rose 结点挂载到 jack 后

        Node lucy = new Node("lucy", null);
        table[3] = lucy;    // 将 lucy 结点，放在table索引位置3处

        System.out.println("table=" + table);
    }
}

class Node {    // 结点，存储数据，可以指向下一个结点，从而形成链表
    Object obj; // 存放数据
    Node next;  // 指向下一个结点

    public Node(Object obj, Node next) {
        this.obj = obj;
        this.next = next;
    }
}