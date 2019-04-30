package com.zhangyan.FileIO;

import java.io.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/22 22:19
 * @Version 1.0
 */
public class BRandBWorPWdemo {
    public static void main(String[] args) throws IOException {
        //对文件进行读写操作
        BufferedReader br=new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("E:\\java\\BFtest\\testDemo.txt"),"gbk"));
        String line;
        BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream("E:\\java\\BFtest\\testDemo3.txt")));

        PrintWriter printWriter=new PrintWriter("E:\\java\\BFtest\\pwDemo.txt");
        while ((line=br.readLine())!=null){
            System.out.println(line);
            bw.write(line);
            //单独写出换行操作
            bw.newLine();
            bw.flush();
            printWriter.println(line);
            printWriter.flush();
        }
        br.close();
        bw.close();
        printWriter.close();


    }
}
