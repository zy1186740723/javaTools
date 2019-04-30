package com.DisruptorDemo;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Author: zhangyan
 * @Date: 2019/4/25 22:26
 * @Version 1.0
 * C1-1消费者类
 */
public class C11EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        long number=longEvent.getNumber();
        number+=10;
        System.out.println(System.currentTimeMillis()+": c1-1 consumer finished.number="+number);
    }

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        long number=longEvent.getNumber();
        number+=10;
        System.out.println(System.currentTimeMillis()+": c1-1 consumer finished.number="+number);
    }
}
