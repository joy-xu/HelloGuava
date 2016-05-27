package com.alibaba.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class BiMapClass {
    public static void main(String[] args) {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
//        biMap.put("2", "Tom");//This call causes an IllegalArgumentException to be thrown!
        biMap.forcePut("2", "Tom");//quietly remove the map entry with the same value before placing the key-value pair in the map

        BiMap<String, String> inverseMap = biMap.inverse();
        System.out.println();
    }
}
