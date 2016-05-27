package com.alibaba.Files;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by xuliang.sxl on 2016/5/20.
 */
public class FilesClass {
    public static void main(String[] args) throws IOException {
        /**
         * Copy/Move/Rename a file
         */
        File originalFile = new File("D:/test/from/xx.txt");
        File copyFile = new File("D:/test/to/copy.txt");
        File newFile = new File("D:/test/to/new.txt");
        Files.copy(originalFile, copyFile);
//        Files.move(originalFile, newFile);
        /**
         * Files as strings
         */
        List<String> lines = Files.readLines(originalFile, Charsets.UTF_8);

        List<String> lines1 = Files.readLines(originalFile, Charsets.UTF_8, new LineProcessor<List<String>>() {

            private List<String> lines = Lists.newArrayList();

            public boolean processLine(String line) throws IOException {
                lines.add(String.valueOf(line.length()));
                return true;
            }

            public List<String> getResult() {
                return lines;
            }
        });

        /**
         * Hashing a file
         */
        HashCode hashCode = Files.hash(originalFile, Hashing.md5());

        /**
         * Write to file
         */
        File tmpFile = new File("D:/test/quote.txt");
        tmpFile.deleteOnExit();
        Files.write("ni好O", tmpFile, Charsets.UTF_8);
        Files.append("append", tmpFile, Charsets.UTF_8);
        Files.write("overwrite", tmpFile, Charsets.UTF_8);

        /**
         * ByteSource/CharSource
         */
        File f1 = new File("d:/test/dir.zip");
        ByteSource byteSource = Files.asByteSource(f1);
        byte[] readBytes = byteSource.read();
        byte[] bytes = Files.toByteArray(f1);
        /**
         * ByteSink/CharSink
         */

        File dest = new File("d:/test/byteSink.zip");
        dest.deleteOnExit();
        ByteSink byteSink = Files.asByteSink(dest);
//        byteSink.write(bytes);

        byteSource.copyTo(byteSink);


        System.out.println("end");


    }
}
