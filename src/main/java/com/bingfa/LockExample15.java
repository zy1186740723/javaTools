package com.bingfa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhangyan
 * @Date: 2019/4/23 14:54
 * @Version 1.0
 *  展示lock的方法
 */
public class LockExample15 {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
        lock.tryLock();
    }

}
