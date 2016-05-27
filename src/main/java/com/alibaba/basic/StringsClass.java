package com.alibaba.basic;

import com.google.common.base.Strings;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class StringsClass {
    public static void main(String[] args) {
        String s = "abc";
        String s1 = Strings.padEnd(s, 3, 'x');
        String s2 = Strings.padStart("88332", 6, '0');
        String sss = Strings.padStart("100000", 6, '0');
        String s3 = Strings.nullToEmpty(null);
        String s4 = Strings.nullToEmpty("joy");
        String s5 = Strings.emptyToNull("");
        String s6 = Strings.emptyToNull("joy");
        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        boolean dfd = Strings.isNullOrEmpty(" ");
        boolean nullOrEmpty1 = Strings.isNullOrEmpty(null);
        boolean joy = Strings.isNullOrEmpty("joy");
        String a = Strings.repeat("a", 9);
        String s7 = Strings.commonPrefix("aaadd", "aaddr");
        String s8 = Strings.commonSuffix("ddera", "zaedra");
        System.out.println();
    }
}
