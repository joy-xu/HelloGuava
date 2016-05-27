package com.alibaba.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by xuliang.sxl on 2016/5/20.
 */
public class BaseEncodingClass {

    public static void main(String[] args) throws IOException {
        File file = new File("d:/test/dir.zip");
        BaseEncoding baseEncoding = BaseEncoding.base64();
        String encode = baseEncoding.encode(Files.toByteArray(file));
        byte[] decode = baseEncoding.decode(encode);
        System.out.println("end");
    }
}
