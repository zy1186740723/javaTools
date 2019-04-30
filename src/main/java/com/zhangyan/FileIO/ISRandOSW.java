package com.zhangyan.FileIO;

import java.io.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/22 21:25
 * @Version 1.0
 */
public class ISRandOSW {

    public static void main(String[] args) throws IOException {
        FileInputStream in=new FileInputStream("E:\\java\\BFtest\\testDemo.txt");
        //有编码的问题
        InputStreamReader isr=new InputStreamReader(in,"gbk");
//        int c;
//        while ((c=isr.read())!= -1){
//            System.out.print((char) c);

        FileOutputStream out=new FileOutputStream("E:\\java\\BFtest\\utf8Demo.txt");
        OutputStreamWriter osw=new OutputStreamWriter(out,"utf-8");

//        }
        char[] buffer=new char[8*1024];
        int c;
        //返回的是读取到的字符的个数 批量读取放入buffer数组
        while ((c=isr.read(buffer,0,buffer.length))!= -1){
            String s=new String(buffer,0,c);
            System.out.print(s);
            osw.write(buffer,0,c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
