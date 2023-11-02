package linkedlist_;

public class LinkedList01 {
    public static void main(String[] args) {
        // 模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("韩顺平");
        // 连接三个节点，形成双向链表
        // jack -> tom -> hsp
        jack.next = tom;
        tom.next = hsp;
        // hsp -> tom -> jack
        hsp.pre = tom;
        tom.pre = jack;

        Node first = jack;  // 让first引用指向jack，表示双向链表的头结点
        Node last = hsp;  // 让last引用指向hsp，表示双向链表的尾结点
        // 演示：从头到尾遍历
        System.out.println("===从头到尾===");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        // 演示：从尾到头遍历
        System.out.println("===从未到头===");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        // 演示：链表添加/删除数据
        // jack -> tom -> hsp
        // 在 tom 和 hsp 之间插入 smith
        Node smith = new Node("smith");
        smith.next = tom.next;
        tom.next.pre = smith;
        tom.next = smith;
        smith.pre = tom;
        System.out.println("===插入数据===");   // 插入 smith
        first = jack;
        while (first != null) {
            System.out.println(first);  // jack tom smith hsp
            first = first.next;
        }
        System.out.println("===删除数据===");   // 删除 tom
        jack.next = jack.next.next;
        jack.next.pre = jack;
        first = jack;
        while (first != null) {
            System.out.println(first);  // jack tom smith hsp
            first = first.next;
        }
    }
}

// 定义一个 Node 类，Node对象表示双向链表的一个节点
class Node {
    public Object item; // 存放数据
    public Node next;   // 指向下一个节点
    public Node pre;    // 指向前一个节点
    public Node(Object name) {
        this.item = name;
    }
    public String toString() {
        return "Node name=" + item;
    }
}