package com.zhangyan.FileIO;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 23:23
 * @Version 1.0
 */

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;

/**
 * java.io.File类用于表示文件（目录）
 * File只能用于表示文件的信息，不能用于文件内筒的访问
 */
public class FileDemo {
    public static void main(String[] args) throws Exception{
        File file=new File("E:\\java\\BFtest");
        System.out.println(file.exists());
        if (!file.exists())
            file.mkdir();
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        File file2=new File("E:\\java\\BFtest\\testDemo.txt");
        if (!file2.exists())
            file2.createNewFile();
//        else
//            file2.delete();
        //路径
        System.out.println(file);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file2.getName());


    }

}
