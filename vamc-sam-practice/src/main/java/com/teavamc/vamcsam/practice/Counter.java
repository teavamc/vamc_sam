package com.teavamc.vamcsam.practice;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice
 * @date 2020/10/21 14:41
 */
public class Counter {

    private final AtomicLong aLong = new AtomicLong();

    public void increase(){
        aLong.incrementAndGet();
    }

    public void decrease(){
        aLong.decrementAndGet();
    }

    public static void main(String[] args) {

    }

}
