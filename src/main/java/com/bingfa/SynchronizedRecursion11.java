package com.bingfa;

/**
 * @Author: zhangyan
 * @Date: 2019/4/23 13:56
 * @Version 1.0
 * 描述：  可重入粒度测试：调用雷内另外的方法
 */
public class SynchronizedRecursion11 {
   public synchronized void method1(){
       System.out.println("我是method1");
       method2();

   }

   private synchronized void method2(){
       System.out.println("我是method2");
   }

    public static void main(String[] args) {
        SynchronizedRecursion11 s=new SynchronizedRecursion11();
        s.method1();
    }
}
