package collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection<Object> col = new ArrayList<>();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("倚天屠龙记", "金庸", 12.1));
        col.add(new Book("天龙八部", "金庸", 15.2));
//        System.out.println("col=" + col);
        // 遍历集合
        // 1. 先得到 col 对应的迭代器
        Iterator<Object> iter = col.iterator();
        // 2. 使用 while 循环遍历
        while (iter.hasNext()) {    // 判断是否还有数据
            // 返回下一个元素，类型是 Object
            Object next = iter.next();
            System.out.println("next=" + next);
        }
        // ctrl + j 返回所有快捷键
        // 3. 当退出 while 循环后，这时 iterator 迭代器指向最后一个元素
//        iter.next();    // NoSuchElementException
        // 4. 如果希望再次遍历，需要重置迭代器
        iter = col.iterator();
        // 第二次遍历...
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
