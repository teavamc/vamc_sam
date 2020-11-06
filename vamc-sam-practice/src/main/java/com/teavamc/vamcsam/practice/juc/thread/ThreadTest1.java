package com.teavamc.vamcsam.practice.juc.thread;

/**
 * 三个线程按顺序执行
 * 使用 join 方法
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.concurrence.thread
 * @date 2020/11/3 20:59
 */
public class ThreadTest1 {

    /**
     * 通过 Thread.join() 方法实现
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(new Work(null));
        Thread t2 = new Thread(new Work(t1));
        Thread t3 = new Thread(new Work(t2));

        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable{
        // 传入的线程, 用于先执行完毕的线程
        private Thread beforeThread;
        // 构造器传入优先执行的线程
        public Work(Thread beforeThread){
            this.beforeThread = beforeThread;
        }

        @Override
        public void run() {
            // 如果穿了优先执行的线程
            if (beforeThread != null){
                try {
                    // 在当前线程中让出执行权给 beforeThread ,直到它执行完毕
                    // Tips: join() 方法用一个循环调用 isAlive() 方法判断线程是否存活, 如果存活就持续 waitting
                    beforeThread.join();
                    System.out.println("beforeThread :" + beforeThread.getName() + " completed join,then thread start :" + Thread.currentThread().getName());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("thread start :" + Thread.currentThread().getName());
            }
        }
    }

}
