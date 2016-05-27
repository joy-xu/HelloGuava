package com.alibaba.io;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by xuliang.sxl on 2016/5/11.
 */
public class FilesClass {

    public static void main(String[] args) {
        File file = new File("D:/eclipse-java-ais-style-ali.xml");
        List<String> lines = Lists.newArrayList();
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
    }
}
