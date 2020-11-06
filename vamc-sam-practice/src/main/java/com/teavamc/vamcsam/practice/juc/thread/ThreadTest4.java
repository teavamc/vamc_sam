package com.teavamc.vamcsam.practice.juc.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.concurrence.thread
 * @date 2020/11/4 09:03
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        CountDownLatch c0 = new CountDownLatch(0); //计数器为0
        CountDownLatch c1 = new CountDownLatch(1); //计数器为1
        CountDownLatch c2 = new CountDownLatch(1); //计数器为1

        //c0为0，t1可以执行。t1的计数器减1
        Thread t1 = new Thread(new Work(c0, c1));

        //t1的计数器为0时，t2才能执行。t2的计数器c2减1
        Thread t2 = new Thread(new Work(c1, c2));

        //t2的计数器c2为0时，t3才能执行
        Thread t3 = new Thread(new Work(c2, c2));

        t1.start();
        t2.start();
        t3.start();
    }

    //定义Work线程类，需要传入开始和结束的CountDownLatch参数
    static class Work implements Runnable {
        CountDownLatch c1;
        CountDownLatch c2;

        // 使用传入参数的闭锁
        Work(CountDownLatch c1, CountDownLatch c2) {
            super();
            this.c1 = c1;
            this.c2 = c2;
        }

        public void run() {
            try {
                //前一线程为0才可以执行
                c1.await();
                System.out.println("thread start:" + Thread.currentThread().getName());
                //本线程计数器减少
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
