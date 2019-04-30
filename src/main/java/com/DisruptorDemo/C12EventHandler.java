package com.DisruptorDemo;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Author: zhangyan
 * @Date: 2019/4/25 22:35
 * @Version 1.0
 */
public class C12EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        long number=longEvent.getNumber();
        number*=10;
        System.out.println(System.currentTimeMillis()+": c1-2 consumer finished.number="+number);
    }

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        long number=longEvent.getNumber();
        number*=10;
        System.out.println(System.currentTimeMillis()+": c1-2 consumer finished.number="+number);
    }
}
