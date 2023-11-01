package list_;

import java.util.*;

public class ListExercise02 {
    public static void main(String[] args) {
        // List 接口的实现子类：ArrayList, LinkedList, Vector
//        List<Book> books = new ArrayList<>();
//        List<Book> books = new LinkedList<>();
        List<Book> books = new Vector<>();
        books.add(new Book("三国演义", 12.5, "罗贯中"));
        books.add(new Book("倚天屠龙记", 16.5, "金庸"));
        books.add(new Book("天龙八部", 15.8, "金庸"));
        books.add(new Book("西游记", 13.0, "吴承恩"));

        // 排序前
        System.out.println("===排序前===");
        for (Book book : books) {
            System.out.println(book);
        }

        /*
        1. 按价格排序，从低到高(使用冒泡排序)
        2. 要求使用 ArrayList, LinkedList, Vector三种集合实现
         */
//        books.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book b1, Book b2) {
//                double p1 = b1.getPrice();
//                double p2 = b2.getPrice();
//                double res = p1 - p2;
//                if (res > 0) {
//                    return 1;
//                } else if (res < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
        // 使用自定义冒泡排序
        bubbleSort(books);
        System.out.println("\n===排序后===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void bubbleSort(List<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = list.get(j);
                Book book2 = list.get(j+1);
                if (book1.getPrice() > book2.getPrice()) {
                    Book tmp = book1;
                    list.set(j, book2);
                    list.set(j+1, tmp);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return name + "\t" + price + "\t" + author;
    }
}