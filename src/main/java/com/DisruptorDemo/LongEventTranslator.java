package com.DisruptorDemo;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * @Author: zhangyan
 * @Date: 2019/4/25 22:25
 * @Version 1.0
 * 事件转换类
 */
public class LongEventTranslator implements EventTranslatorOneArg<LongEvent,Long> {
    @Override
    public void translateTo(LongEvent longEvent, long l, Long aLong) {
        longEvent.setNumber(aLong);
    }
}
