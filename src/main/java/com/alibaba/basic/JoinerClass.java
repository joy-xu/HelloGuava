package com.alibaba.basic;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class JoinerClass {
    public static void main(String[] args) {
        String[] stringList = {"a", "b", null};//can be array, iterable, or varargs of any object
        String result = Joiner.on(",").skipNulls().join(stringList);//call object.toString()
        String resultNull = Joiner.on(",").useForNull("null").join(stringList);
        System.out.println(result);
        System.out.println(resultNull);

        StringBuilder sb = new StringBuilder();
        Joiner.on(",").skipNulls().appendTo(sb, stringList);
        System.out.println(sb);

        Joiner.MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");
        String expectedString = "Washington D.C=Redskins#New York "+
        "City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        String returnedString = mapJoiner.join(testMap);
        assertThat(returnedString,is(expectedString));
    }
}
