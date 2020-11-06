package com.teavamc.vamcsam.practice.juc.thread;

import com.alibaba.fastjson.JSONObject;
import com.teavamc.vamcsam.practice.tools.commontools.PrintTools;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 直接继承 thread
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.concurrence.thread
 * @date 2020/10/22 14:41
 */
public class TestInheritThread {

    static AtomicInteger contestScore = new AtomicInteger(1);

    static volatile int tempValue = 0;

    static volatile boolean threadStopFlag = false;

    volatile int roleCode = 1;

    public static void main(String[] args) {
        PrintTools.printInfo("contestScore 初始值为:" + contestScore.intValue());
        MathOpera mathOpera1 = new MathOpera();
        Thread t1 = new RoleThreadA(mathOpera1);
        Thread t2 = new RoleThreadA(mathOpera1);
        t1.start();
        t2.start();
    }

    /**
     * 负责加
     */
    static class RoleThreadA extends Thread {

        MathOpera mathOpera;

        public RoleThreadA(MathOpera mathOpera) {
            this.mathOpera = mathOpera;
        }

        @Override
        public void run() {
            try {
                int roleCode;

                while (true) {
                    if (checkCurrentScoreValue() == WinnerRole.RoleA || checkCurrentScoreValue() == WinnerRole.RoleB) {
                        return;
                    }

                    if (threadStopFlag) {
                        break;
                    }
                    this.mathOpera.mathAction(mathOpera.getRole());

                    if (1000 < contestScore.intValue()) {
                        PrintTools.printInfo("RoleThreadA 胜利了!, 最终分数 contestScore = " + contestScore);
                        threadStopFlag = true;
                        break;
                    } else if (1 > contestScore.intValue()) {
                        PrintTools.printInfo("RoleThreadB 胜利了!, 最终分数 contestScore = " + contestScore);
                        threadStopFlag = true;
                        break;
                    }
                }
            } catch (Exception e) {
                PrintTools.printInfo("线程错误:" + JSONObject.toJSON(e));

            }

        }
    }

    enum WinnerRole {
        RoleA(1),
        RoleB(2),
        Unknow(3);

        int code;

        WinnerRole(int i) {
            this.code = i;
        }
    }

    static WinnerRole checkCurrentScoreValue() {
        int curValue = contestScore.intValue();
        if (curValue < 1) {
            return WinnerRole.RoleA;
        } else if (curValue > 100) {
            return WinnerRole.RoleB;
        } else {
            return WinnerRole.Unknow;
        }
    }

    static class MathOpera {

        WinnerRole role;

        void setRole(WinnerRole role) {
            this.role = role;
        }

        WinnerRole getRole() {
            return this.role;
        }


        Lock lock = new ReentrantLock();

        public void mathAction(WinnerRole winnerRole) {
            lock.lock();
            if (contestScore.get() < 1 || contestScore.get() > 100) {
                return;
            }
            int preValue = contestScore.get();
            tempValue = preValue;
            int randomValue = getRandomInteger();
            int newValue = 0;
            if (WinnerRole.RoleA.equals(winnerRole)) {
                // 做加法
                newValue = preValue + randomValue;
                PrintTools.printInfo("Role a 将分数:" + preValue + " 加上:" + randomValue + "得到当前值" + newValue);
            } else {
                // 做减法
                newValue = preValue - randomValue;
                PrintTools.printInfo("Role b 将分数:" + preValue + " 减去:" + randomValue + "得到当前值" + newValue);
            }
            contestScore.compareAndSet(tempValue, newValue);
            PrintTools.printInfo("提交后当前值为: " + contestScore.intValue());
            lock.unlock();
        }

        Integer getRandomInteger() {
            Random random = new Random();
            int randomValue = random.nextInt(10);
//        PrintTools.printInfo("获得随机数:" + randomValue);
            return randomValue;
        }

    }


}
