package com.zhangyan.Reflection;

/**
 * @Author: zhangyan
 * @Date: 2019/4/13 22:27
 * @Version 1.0
 */
public class Office implements OfficeAble{
    @Override
    public void start() {
        System.out.println("Office");
    }
}
