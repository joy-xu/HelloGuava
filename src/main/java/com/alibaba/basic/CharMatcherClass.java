package com.alibaba.basic;

import com.google.common.base.CharMatcher;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class CharMatcherClass {
    public static void main(String[] args) {
        String s = CharMatcher.BREAKING_WHITESPACE.replaceFrom("a\nb", " ");
        String foo989 = CharMatcher.DIGIT.retainFrom("foo989");
        String tabsAndSpaces = "String with         spaces and tabs";
        String expected = " String with spaces and tabs ";
        String scrubbed = CharMatcher.WHITESPACE.
                collapseFrom(tabsAndSpaces,' ');
        String s1 = CharMatcher.WHITESPACE.trimAndCollapseFrom(" dfdf       dff  ", ' ');
        CharMatcher newCharMatcher = CharMatcher.JAVA_DIGIT.or(CharMatcher.WHITESPACE);
        String s2 = CharMatcher.JAVA_LOWER_CASE.replaceFrom("ddSDFefdfdaDFA", "adf");
        String s3 = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).removeFrom("foo32AC");
        System.out.println();

    }
}
