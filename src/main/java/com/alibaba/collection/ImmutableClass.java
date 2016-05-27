package com.alibaba.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class ImmutableClass {
    public static void main(String[] args) {
        ImmutableList<String> list = ImmutableList.of("a", "b");
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("key1", "value1", "key2", "value2");

        ImmutableListMultimap.Builder<Integer, String> integerStringBuilder = new ImmutableListMultimap.Builder<Integer, String>().put(1, "1").putAll(2, "2", "3");
        ImmutableListMultimap<Integer, String> map = integerStringBuilder.putAll(3,"34","434").build();
        System.out.println();
    }
}
