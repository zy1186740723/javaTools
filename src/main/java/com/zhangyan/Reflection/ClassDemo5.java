package com.zhangyan.Reflection;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 23:43
 * @Version 1.0
 */
public class ClassDemo5 {
    public static void main(String[] args) {
        ClassUtil.printConMessage("String");
        System.out.println("==============");
        ClassUtil.printConMessage(new Integer(1));
    }
}
