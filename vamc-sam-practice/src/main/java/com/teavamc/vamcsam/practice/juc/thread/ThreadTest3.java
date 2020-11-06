package com.teavamc.vamcsam.practice.juc.thread;

/**
 * 子线程先执行,再主线程执行
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.concurrence.thread
 * @date 2020/11/3 22:34
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程睡眠: " + i + "秒...");
            }
        });
        thread.start();
        for (int i = 1; i < 4; i++) {
            try {
                thread.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程睡眠: " + i + "秒...");
        }
    }
}
