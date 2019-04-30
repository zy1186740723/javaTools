package com.zhangyan.FileIO;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 23:43
 * @Version 1.0
 */
public class FileUtilsTest {
    public static void main(String[] args) throws  Exception{
        FileUtils.listDirectory(new File("E:\\java\\BFtest"));
    }


}