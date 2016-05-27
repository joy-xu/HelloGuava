package com.alibaba.collection;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class SetsClass {
    public static void main(String[] args) {
        Set<String> s1 = Sets.newHashSet("1","2","3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        /**
         * return the elements found in the first set but not in the second
         */
        Sets.SetView<String> difference = Sets.difference(s1, s2);
        /**
         * return elements that are contained in one set or the other, but not contained in both
         */
        Sets.SetView<String> strings = Sets.symmetricDifference(s1, s2);
        Sets.SetView<String> intersection = Sets.intersection(s1, s2);
        Sets.SetView<String> union = Sets.union(s1, s2);
        System.out.println();
    }
}
