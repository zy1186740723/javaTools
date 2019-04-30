package com.zhangyan.FileIO;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 9:30
 * @Version 1.0
 */
public class IOUtilsTest {

    @Test
    public  void printHex() throws IOException {
        IOUtils.printHex("E:\\java\\BFtest\\testDemo.txt");
    }
}