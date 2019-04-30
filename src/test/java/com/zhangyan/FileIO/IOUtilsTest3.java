package com.zhangyan.FileIO;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 10:13
 * @Version 1.0
 */
public class IOUtilsTest3 {

    @Test
    public void printHexByByteArray2() throws IOException {
        IOUtils.printHexByByteArray2("E:\\java\\BFtest\\testDemo.txt");
    }
}