package com.bingfa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhangyan
 * @Date: 2019/4/23 14:25
 * @Version 1.0
 */
public class SynchronizedTOlock13 {
    Lock lock=new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是synchro形式的锁");
    }

    public void method2(){
        lock.lock();
        try {
            System.out.println("我是lock像是的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedTOlock13 s=new SynchronizedTOlock13();
        s.method1();
        s.method2();
    }
}
