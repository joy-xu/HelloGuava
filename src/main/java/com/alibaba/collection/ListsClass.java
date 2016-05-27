package com.alibaba.collection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class ListsClass {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<List<Integer>> subList = Lists.partition(list, 3);
        List<Integer> reverse = Lists.reverse(list);
        List<String> transform = Lists.transform(list, new Function<Integer, String>() {
            public String apply(Integer integer) {
                return integer + " dd";
            }
        });
        System.out.println();
    }
}
