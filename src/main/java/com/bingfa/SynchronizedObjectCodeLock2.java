package com.bingfa;

/**
 * @Author: zhangyan
 * @Date: 2019/4/16 20:41
 * @Version 1.0
 */
public class SynchronizedObjectCodeLock2 implements Runnable{
    static SynchronizedObjectCodeLock2 instance=new SynchronizedObjectCodeLock2();
    Object lock1=new Object();
    Object lock2=new Object();

    /**
     *
     */
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是第一部分的代码块形式，我叫" +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "lock1运行结果。");
        }
        synchronized (lock2) {
            System.out.println("我是第二部分的代码块形式，我叫" +
                    Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "lock2运行结果。");
        }
    }

    public synchronized void method(){
        System.out.println("我的对像素ode方法修饰符形式");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }

}
