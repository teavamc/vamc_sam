package com.teavamc.vamcsam.practice.juc.thread;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.juc.thread
 * @date 2020/11/4 13:44
 */
public class TreadObject {

    private int state = 0;

    public int getState() {
        return state;
    }

    /**
     * 使用 synchronized 锁方法
     * @param state
     */
    public synchronized void setState(int state) {
        System.out.println(" preValue = :" + this.state + " reuqestValue = :" + state);
        this.state = state;
    }


}
