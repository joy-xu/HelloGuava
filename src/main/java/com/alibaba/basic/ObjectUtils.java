package com.alibaba.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class ObjectUtils {
    public static void main(String[] args) {
        Book book = new Book("Google guava", "Google");
        System.out.println(book);
        String s = MoreObjects.firstNonNull(null, "s");
        System.out.println(s);
    }
}

class Book implements Comparable<Book> {
    private String title;
    private String publisher;
    private String isbn;
    private double price;

    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public int hashCode() {
        return Objects.hashCode(title, publisher, isbn, price);
    }

    public int compareTo(Book o) {
        return ComparisonChain.start().compare(this.title, o.title)
                .compare(this.publisher, o.publisher)
                .result();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("title", title).add("publisher", publisher).toString();
    }

}