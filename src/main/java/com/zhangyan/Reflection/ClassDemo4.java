package com.zhangyan.Reflection;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 23:33
 * @Version 1.0
 */
public class ClassDemo4 {

    public static void main(String[] args) {
        ClassUtil.printFieldMessage("hellow");
        System.out.println("==========================");
        ClassUtil.printFieldMessage(new Integer(1));
    }
}
