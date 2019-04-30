package com.FanXing;

/**泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中
 * @Author: zhangyan
 * @Date: 2019/4/14 21:19
 * @Version 1.0
 */

public interface Demo2<T> {
    public T next();
}
/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 *  * 即：class FruitGenerator<T> implements Generator<T>{
 *  * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 *
 */

class FG<T> implements Demo2<T>{
    @Override
    public T next() {
        return null;
    }
}

