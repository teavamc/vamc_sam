package com.teavamc.vamcsam.practice.jdk.jvm;

import com.teavamc.vamcsam.practice.tools.commontools.PrintTools;

/**
 * 写个死锁
 * - 互斥 : 一个资源同一时刻只能被一个进程使用
 * - 请求与保持 : 一个请求因请求而被阻塞时,对方获得的资源保持不变
 * - 不可剥夺 : 已获取的资源没有使用完前,不可剥夺
 * - 循环等待 : 若干进程之前行程头尾相接的循环等待资源关系
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.jdk.jvm
 * @date 2020/10/28 14:05
 */
public class TestDeadLock {

    final static Object resourceA = new Object();
    final static Object resourceB = new Object();

    public static void main(String[] args) {
        new TaskA().start();
        new TaskB().start();
    }

    static class TaskA extends Thread {
        @Override
        public void run() {
            try {
                synchronized (resourceA) {
                    PrintTools.printInfo("TaskA got the resource_A");
                    synchronized (resourceB) {
                        PrintTools.printInfo("TaskA got the resource_B");
                    }
                }
            } catch (Exception e) {
                PrintTools.printInfo("Error" + e);
            }
        }
    }

    static class TaskB extends Thread {
        @Override
        public void run() {
            try {
                synchronized (resourceB) {
                    PrintTools.printInfo("TaskB got the resource_B");
                    synchronized (resourceA) {
                        PrintTools.printInfo("TaskB got the resource_A");
                    }
                }
            } catch (Exception e) {
                PrintTools.printInfo("Error" + e);
            }
        }
    }

}
