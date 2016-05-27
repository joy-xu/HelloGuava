package com.alibaba.collection;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.*;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class MapsClass {
    static class Book {
        private String isbn;
        private String name;

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Book(String isbn, String name) {
            this.isbn = isbn;
            this.name = name;

        }
    }

    public static void main(String[] args) {
        List<Book> books = Lists.newArrayList(new Book("1", "haha"), new Book("2", "hehe"));

        /**
         * The same as the following code
         *  Map<String, Book> bookMap = Maps.newHashMap();
         *  for (Book book : books) {
         *    bookMap.put(book.getIsbn(), book);
         *  }
         */
        Map<String, Book> bookMap = Maps.uniqueIndex(books.iterator(), new Function<Book, String>() {
            public String apply(Book book) {
                return book.isbn;
            }
        });

        List<Book> emptyBookes = Lists.newArrayList();
        Map<String, Book> empty = Maps.uniqueIndex(emptyBookes.iterator(), new Function<Book, String>() {
            public String apply(Book input) {
                return input.getIsbn();
            }
        });



        Set<String> sets = Sets.newHashSet("1", "2");
        Map<String, Book> map = Maps.asMap(sets, new Function<String, Book>() {
            public Book apply(String s) {
                return new Book(s, s + " haha");
            }
        });
        ImmutableMap<String, Book> immutableMap = Maps.toMap(sets, new Function<String, Book>() {
            public Book apply(String s) {
                return new Book(s, s + " haha");
            }
        });

        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");
        multiMap.put("Bar", "1");
        multiMap.put("Bar", "2");
        multiMap.put("Bar", "3");
        //The call to size() takes into account all values found in each List, and not the total number of List instances in the map
        int size = multiMap.size();//7
        Collection<String> values = multiMap.values();
        Map<String, Collection<String>> trueMap = multiMap.asMap();
        multiMap.put("Foo1", "1");
        int trueSize = trueMap.size();
        //the returned map would not support the put(key,value) call as before
//        trueMap.put("Bar1", new ArrayList<String>());//java.lang.UnsupportedOperationException

        HashMultimap<String,String> multiMap1 =
                HashMultimap.create();
        multiMap1.put("Bar","1");
        multiMap1.put("Bar","2");
        multiMap1.put("Bar","3");
        multiMap1.put("Bar","3");
        multiMap1.put("Bar","3");


        MapDifference<Object, Object> difference = Maps.difference(Maps.newHashMap(), Maps.newHashMap());
        boolean b = difference.areEqual();
        Map<Object, Object> objectObjectMap = difference.entriesInCommon();
        Map<Object, MapDifference.ValueDifference<Object>> objectValueDifferenceMap = difference.entriesDiffering();
        System.out.println();
    }
}
