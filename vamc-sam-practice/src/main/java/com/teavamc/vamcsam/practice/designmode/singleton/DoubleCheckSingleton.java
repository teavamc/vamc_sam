package com.teavamc.vamcsam.practice.designmode.singleton;

import com.teavamc.vamcsam.practice.tools.commontools.PrintTools;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.dp.singleton
 * @date 2020/10/29 11:39
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
        PrintTools.printInfo("这是双重锁校验单例");
    }

    public static DoubleCheckSingleton getInstance() {
        if (ObjectUtils.isEmpty(instance)) {
            synchronized (DoubleCheckSingleton.class) {
                if (ObjectUtils.isEmpty(instance)) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
