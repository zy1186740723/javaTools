package com.FanXing;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 21:08
 * @Version 1.0
 */

import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**1、此处T可以随便写为任意标识，常见的如T、E、K、V等
 * 形式的参数常用于表示泛型
 *
 * 2、在实例化泛型类时，必须指定T的具体类型
 *
 * @param <T>
 */
public class Demo1<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Demo1(T key){
        this.key=key;
    }

    public T getKey(){
        return key;
    }

    //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
    //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
    public static void main(String[] args) {
        Demo1<Integer> demo1=new Demo1<>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Demo1<String> demo2=new Demo1<>("keyValue");

        System.out.println(demo1.getKey());
        System.out.println(demo2.getKey());

        Demo1 demo3=new Demo1("55.67");
        System.out.println(demo3.getKey());


    }



}
