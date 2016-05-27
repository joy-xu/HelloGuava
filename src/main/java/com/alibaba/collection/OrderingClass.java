package com.alibaba.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class OrderingClass {
    public static void main(String[] args) {

        Ordering<MapsClass.Book> byIsbn = Ordering.from(new Comparator<MapsClass.Book>() {
            public int compare(MapsClass.Book o1, MapsClass.Book o2) {
                return o1.getIsbn().compareTo(o2.getIsbn());
            }
        }).nullsLast();

        Ordering<MapsClass.Book> byNameReverse = Ordering.from(new Comparator<MapsClass.Book>() {
            public int compare(MapsClass.Book o1, MapsClass.Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).reverse();

        List<MapsClass.Book> books = Lists.newArrayList(new MapsClass.Book("2", "1"), new MapsClass.Book("1", "2"));

        List<MapsClass.Book> books1 = byIsbn.leastOf(books, 1);
        List<MapsClass.Book> books2 = byIsbn.greatestOf(books, 1);

        List<MapsClass.Book> books3 = Ordering.from(byIsbn).compound(byNameReverse).sortedCopy(books);

        Collections.sort(books, byIsbn);

        System.out.println();

    }
}
