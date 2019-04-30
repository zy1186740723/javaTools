package com.zhangyan.FileIO;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 10:01
 * @Version 1.0
 */
public class IOUtilsTest2 {

    @Test
    public void printHexByByteArray() throws IOException {
        IOUtils.printHexByByteArray("E:\\java\\BFtest\\testDemo.txt");
    }
}