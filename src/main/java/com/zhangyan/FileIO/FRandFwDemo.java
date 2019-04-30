package com.zhangyan.FileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: zhangyan
 * @Date: 2019/4/22 21:55
 * @Version 1.0
 */
public class FRandFwDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("E:\\java\\BFtest\\testDemo.txt");
        //字符读写
        FileWriter fileWriter=new FileWriter("E:\\java\\BFtest\\testDemo2.txt");
        char[] buffer=new char[2056];
        int c;
        while ((c=fr.read(buffer,0,buffer.length))!=-1){
            fileWriter.write(buffer,0,c);
            fileWriter.flush();
        }
        fr.close();
        fileWriter.close();
    }

}
