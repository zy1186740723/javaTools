package com.FanXing;

/**
 * @Author: zhangyan
 * @Date: 2019/4/14 22:40
 * @Version 1.0
 */
public class FXLimition<T extends Number> {
    private T key;

    public FXLimition(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }

    public void showKeyValue1(FXLimition<? extends Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());

    }
}
