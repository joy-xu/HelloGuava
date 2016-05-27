package com.alibaba.basic;

import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class CharsetsClass {
    public static void main(String[] args) {
        String s = "joy";

        byte[] bytes = new byte[0];
        try {
            bytes = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();//will never be thrown This really can't happen UTF-8 must be supporte
        }

        byte[] bytes1 = s.getBytes(Charsets.UTF_8);
        byte[] bytes2 = s.getBytes(StandardCharsets.UTF_8);//since 1.7 StandardCharsets also provides static final definitions to the six standard character sets supported on the Java platform

        System.out.println(bytes);
    }
}
