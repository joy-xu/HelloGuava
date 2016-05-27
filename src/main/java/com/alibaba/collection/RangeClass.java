package com.alibaba.collection;

import com.google.common.collect.Range;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class RangeClass {
    public static void main(String[] args) {
        Range<Integer> numberRange = Range.closed(1,10);
//both return true meaning inclusive
        numberRange.contains(10);
        numberRange.contains(1);
        System.out.println();
    }
}
