package com.alibaba.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.List;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class PredictInterface {

    static class PopulationPredicate implements Predicate<Integer> {
        public boolean apply(Integer input) {
            return input <= 500000;
        }
    }

    public static void main(String[] args) {
        PopulationPredicate populationPredicate = new PopulationPredicate();
        boolean apply = populationPredicate.apply(100);
        List<String> names = ImmutableList.of("Aleksander", "Jaran", "Integrasco", "Guava", "Java");
        FluentIterable<String> filter = FluentIterable.from(names).filter(new Predicate<String>() {
            public boolean apply(String s) {
                return s.length() > 5;
            }
        });

        Predicate<Integer> predicate = new Predicate<Integer>() {
            public boolean apply(Integer input) {
                return input >=1000;
            }
        };

        boolean apply1 = Predicates.and(populationPredicate, predicate).apply(100);
        boolean apply2 = Predicates.or(populationPredicate, predicate).apply(100);
        boolean apply3 = Predicates.not(populationPredicate).apply(100);
        Predicate<String> compose = Predicates.compose(populationPredicate, new Function<String, Integer>() {
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });
        boolean apply4 = compose.apply("1000");

        System.out.println();
    }
}
