package com.DisruptorDemo;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author: zhangyan
 * @Date: 2019/4/25 22:38
 * @Version 1.0
 */
public class MainMethod {
    public static void main(String[] args) {
        int bufferSize=1024*1024;
        EventFactory<LongEvent> eventFactory=new LongEventFactory();
        ThreadFactory producerFactory = Executors.defaultThreadFactory();

        /**
         * 定于Disputor 基于单生产者，阻塞策略
         */
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(eventFactory,bufferSize,producerFactory,
                ProducerType.SINGLE ,new BlockingWaitStrategy());
        /**
         * 进行不用的计算方法，并行或者交叉
         */
        parallel(disruptor);

        RingBuffer<LongEvent> ringBuffer=disruptor.getRingBuffer();

        //输入为10
        ringBuffer.publishEvent(new LongEventTranslator(),10L);
        ringBuffer.publishEvent(new LongEventTranslator(),100L);


    }

    /**
     * 消费者并行计算
     */
    public static void parallel(Disruptor<LongEvent> disruptor){
        disruptor.handleEventsWith(new C11EventHandler(),new C21EventHandler());
        disruptor.start();

    }
}
