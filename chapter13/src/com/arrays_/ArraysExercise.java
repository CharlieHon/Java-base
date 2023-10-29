package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book("红楼梦", 100),
                new Book("金瓶梅", 90),
                new Book("青年文摘", 15),
                new Book("java从入门到放弃", 120)
        };
        for (Book book :
                books) {
            System.out.println(book);
        }
        System.out.println("===按价格(从大到小)排序后===");

//        Arrays.sort(books, new Comparator<Book>() {   // 方式1：使用 Arrays.sort()
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getPrice() - o1.getPrice();
//            }
//        });

        bubbleSort(books, new Comparator() {    // 方式2：使用静态方法
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double priceDiff = b2.getPrice() - b1.getPrice();
                if (priceDiff > 0) {    // 因为重写的 compare 返回类型是 int
                    return 1;
                } else if (priceDiff < 0) {
                    return -1;
                } else {
                    return 0;
                }
//                return ;   // 按价格从大到小
//                return b2.getLength() - b1.getLength(); // 按书名长度从大到小
            }
        });

        for (Book book :    // 输出排序后结果
                books) {
            System.out.println(book);
        }
    }

    public static void bubbleSort(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j], books[j+1]) > 0) {
                    Book tmp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = tmp;
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return name.length();   // 返回书名长度
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "书名：" + name + "\t价格：" + price;
    }
}