package com.alibaba.basic;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class SplitterClass {
    public static void main(String[] args) {
        String testString = "  Monday,Tuesday,,Thursday,Friday,,";
        String[] parts = testString.split(",");
        System.out.println(parts);

        Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);
        System.out.println(split);

        Splitter splitterPattern = Splitter.onPattern(",\\s*");

        String startString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");
        Splitter.MapSplitter mapSplitter =
                Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap =
                mapSplitter.split(startString);
        assertThat(testMap, is(splitMap));

    }
}
