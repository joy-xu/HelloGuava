package com.alibaba.collection;

import com.google.common.collect.ArrayListMultimap;

/**
 * Created by xuliang.sxl on 2016/5/11.
 */
public class ArrayListMultimapClass {

    public static void main(String[] args) {
        ArrayListMultimap<Integer, Object> multimap = ArrayListMultimap.create();
        multimap.put(1, new Object());
        multimap.put(2, new Object());
        multimap.put(2, new Object());
        multimap.put(3, new Object());
        System.out.println(multimap);
    }
}
