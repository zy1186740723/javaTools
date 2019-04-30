package com.DisruptorDemo;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * @Author: zhangyan
 * @Date: 2019/4/25 22:20
 * @Version 1.0
 * 事件工厂类，用来产生事件
 */
public class LongEventFactory implements EventFactory <LongEvent>{
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
