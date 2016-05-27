package com.alibaba.cache;

import com.google.common.collect.MapMaker;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by xuliang.sxl on 2015/11/3.
 */
public class MapMakerClass {
    public static void main(String[] args) {
        ConcurrentMap<String, Object> books = new MapMaker().concurrencyLevel(2).weakValues().makeMap();
    }
}
