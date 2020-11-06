package com.teavamc.vamcsam.practice.juc.tools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 计数器
 *
 * 拦截一个或多个线程使其在某个条件成熟后再执行。
 * 它的内部提供了一个计数器，在构造闭锁时必须指定计数器的初始值，且计数器的初始值必须大于0。
 * 另外它还提供了一个countDown方法来操作计数器的值，每调用一次countDown方法计数器都会减1，
 * 直到计数器的值减为0时就代表条件已成熟，所有因调用await方法而阻塞的线程都会被唤醒。
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.concurrence.tools
 * @date 2020/11/4 10:15
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = () -> service.exec();

        // 开五个线程/每个线程最后都会把计数器-1
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        // 主线程等待
        System.out.println("main thread await. ");
        // 等待计数器为 0 则跳出 await
        latch.await();
        System.out.println("main thread finishes await. ");
    }

    public static class Service {
        private CountDownLatch latch;

        public Service(CountDownLatch latch) {
            this.latch = latch;
        }

        public void exec() {
            try {
                // 线程执行过程
                System.out.println(Thread.currentThread().getName() + " execute task. ");
                sleep(2);
                System.out.println(Thread.currentThread().getName() + " finished task. ");
            } finally {
                // 最后还是要把计数器减一
                latch.countDown();
            }
        }

        private void sleep(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


