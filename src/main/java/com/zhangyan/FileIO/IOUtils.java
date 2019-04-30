package com.zhangyan.FileIO;

import java.io.*;

/**
 * @Author: zhangyan
 * @Date: 2019/4/15 9:24
 * @Version 1.0
 */
public class IOUtils {
    /**
     * 读取指定文件内容 按照16进制输出到控制台
     * 并且每输出10个byte换行
     */
    public static void printHex(String filename) throws IOException {
        //文件利用字节流进行读操作
        FileInputStream in =new FileInputStream(filename);
        int b;
        int i=1;
        while ((b=in.read())!=-1){
//            if (b<=0xf){
//                //单位数签名补充0
//                System.out.println("0");
//            }
            //将b整型郑华为16进制表示的字符串
            System.out.print(Integer.toHexString(b)+" ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
            }
        in.close();
        }

        public static void printHexByByteArray(String filename) throws IOException{
            FileInputStream in =new FileInputStream(filename);
            byte[] buf=new byte[2*1024];
            //从in中批量读取字节，放入到buf这个字节数组中，对多方
            //buf.length 返回独到的字节的个数!!!!!!!
            int bytes=in.read(buf,0,buf.length);//一次性读完，字节数组足够大
            int j=1;
            for (int i = 0; i < bytes; i++) {
                if (buf[i]<=0xff){
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
                if (j++%10==0){
                    System.out.println();
                }
            }
        }


        public static void printHexByByteArray2(String filename) throws  IOException{
            FileInputStream in =new FileInputStream(filename);
            byte[] buf=new byte[2*1024];
            int bytes=0;
            int j=1;
            while ((bytes=in.read(buf,0,buf.length))!=-1){
                for (int i = 0; i < bytes; i++) {
                    System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
                    if (j++ % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        }

        public static void copyFile(File srcFile,File destFile) throws  IOException{
            if (!srcFile.exists()){
                throw new IllegalArgumentException("文件不存在");
            }
            if (!srcFile.isFile()){
                throw new IllegalArgumentException("不是文件");
            }
            FileInputStream in =new FileInputStream(srcFile);
            FileOutputStream out=new FileOutputStream(destFile);

            /**
             * 进行批量的读写
             */
            byte[] buf=new byte[8*1024];
            int b;
            while ((b=in.read(buf,0,buf.length))!=-1){
                //b表示的读取的字节的长度
                out.write(buf,0,b);
                out.flush();
            }
            out.close();

        }

    /**
     * 进行文件拷贝，利用带缓冲的字节流
     * @param srcFile
     * @param destFile
     */
    public static void copyFileByBuf(File srcFile,File destFile)throws IOException{
        if (!srcFile.exists()){
            throw new IllegalArgumentException("文件不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException("不是文件");
        }
        BufferedInputStream bis=new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(
                new FileOutputStream(destFile));
        int c;
        while ((c=bis.read())!=-1){
            bos.write(c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
        }

    public static void main(String[] args) throws  IOException{
        IOUtils.copyFile(new File("E:\\java\\BFtest\\testDemo.txt"),new File("dest.txt"));
        IOUtils.copyFileByBuf(new File("E:\\java\\BFtest\\testDemo.txt"),new File("dest2.txt"));
    }



    }


