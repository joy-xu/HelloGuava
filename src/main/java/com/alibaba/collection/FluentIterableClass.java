package com.alibaba.collection;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class FluentIterableClass {
    public static void main(String[] args) {
        List list = Lists.newArrayList(1, 2, 3, 4, 50);
        Iterable<Integer> filtered =
                FluentIterable.from(list).filter(new Predicate<Integer>() {
                    public boolean apply(Integer input) {
                        return input > 31;
                    }
                });
        assertThat(Iterables.contains(filtered, 1),
                is(false));
        assertThat(Iterables.contains(filtered, 2),
                is(false));
        assertThat(Iterables.contains(filtered, 3),
                is(false));
        assertThat(Iterables.contains(filtered, 50),
                is(true));

        List<String> transformedPersonList =
                FluentIterable.from(list).transform(new Function<Integer,
                                        String>() {
                    public String apply(Integer input) {
                        return "Hello" + input;
                    }
                }).toList();
        System.out.println(transformedPersonList);
    }
}
