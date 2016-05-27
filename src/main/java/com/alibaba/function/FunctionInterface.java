package com.alibaba.function;

import com.alibaba.basic.ObjectUtils;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class FunctionInterface {
    public static void main(String[] args) {
        Function<Date,String> function = new Function<Date, String>() {
            /**
             * A good implementation should have no side effect
             * @param input
             * @return
             */
            public String apply( Date input) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(input);
            }
        };
        String date = function.apply(new Date());
        System.out.println(date);

        Map<String, Object> stateMap = new HashMap<String, Object>();
        stateMap.put("LA", "Los Ang");
        stateMap.put("NY", "New York");
        Function<String, Object> lookup = Functions.forMap(stateMap, "default value");
        Object la = lookup.apply("LA");
        Object dd = lookup.apply("dd");


        Map<String, List> map = new HashMap<String, List>();
        List list = new ArrayList();
        list.add("Los Ang");
        list.add("New York");
        map.put("LA", list);
        Function<String, List> lookup2 = Functions.forMap(map);
        Function<List, String> stateFunction = new StateToCityString();
        Function<String,String> composed =
                Functions.compose(stateFunction, lookup2);
        String la1 = composed.apply("LA");

        Map<String, String> newMap = Maps.transformValues(map, new Function<List, String>() {
            public String apply(List list) {
                return Joiner.on(",").skipNulls().join(list);
            }
        });



        System.out.println(la1);
    }

    static class StateToCityString implements Function<List, String> {
        public String apply(List input) {
            return Joiner.on(",").join(input);
        }
    }

}
