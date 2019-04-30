package com.zhangyan.FileIO;

import java.io.File;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 23:38
 * @Version 1.0
 */
public class FileUtils {
    /**
     * 列出file类的常用操作
     */


    /**
     * 列出制定目录下，包括其子目录的所有文件
     * @param dir
     * @throws Exception
     */
    public static void listDirectory(File dir) throws  Exception{
        if (!dir.exists())
            throw new IllegalArgumentException("目录不存在" );
        if (!dir.isDirectory())
            throw new IllegalArgumentException(dir+"不是目录" );
        String[] strings=dir.list();//返回了字符串数组，不包含子目录下的内容
        for (String string : strings) {
            System.out.println(dir+string);
        }
        //如果要遍历自目录下的内筒，就要构造File对象做递归操作
        File[] files=dir.listFiles();//返回的是子目录的对象
//        for (File file : files) {
//            System.out.println(file);
//        }
        if (files!=null&&files.length>0){
            for (File file : files) {
                if (file.isDirectory()){
                    //递归
                    listDirectory(file);
                }
                else
                    //递归终止的条件
                    System.out.println(file);
            }
        }


    }


}
