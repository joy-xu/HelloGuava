package com.alibaba.primitices;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * Created by xuliang.sxl on 2015/11/3.
 */
public class IntsClass {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1, 2, 3, 4};
        boolean contains = Ints.contains(arr, 1);
        int i = Ints.indexOf(arr, 2);
        List<Integer> integers = Ints.asList(arr);
        int max = Ints.max(arr);
        int min = Ints.min(arr);
        int[] ints = Ints.toArray(Lists.newArrayList(1));
        int[] concat = Ints.concat(arr, arr1);
        int compare = Ints.compare(1, 3);
        String join = Ints.join(",", arr);
        System.out.println();
    }
}
