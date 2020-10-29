package com.teavamc.vamcsam.practice.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.lock
 * @date 2020/10/24 11:24
 */
public class TestReadWriteLock {
    public static void main(String[] args){
        ReadWriteLockDemo rwd = new ReadWriteLockDemo();
        //启动100个读线程
        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.get();
                }
            }).start();

            if (50 == i){
                //写线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        rwd.set((int)(Math.random()*101));
                    }
                },"Write").start();
            }

        }
    }
}

class ReadWriteLockDemo{
    //模拟共享资源--Number
    private int number = 0;
    // 实际实现类--ReentrantReadWriteLock，默认非公平模式
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读
    public void get(){
        //使用读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" : "+number);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
    //写
    public void set(int number){
        readWriteLock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName()+" : "+number);
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}