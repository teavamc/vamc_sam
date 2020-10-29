package com.teavamc.vamcsam.service.practice.dp.singleton;

import com.teavamc.vamcsam.service.practice.tools.PrintTools;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 懒汉式，线程不安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.singleton
 * @date 2020/10/29 10:39
 */
public class LazyNotSafeSingleton {

    private static LazyNotSafeSingleton instance;

    private LazyNotSafeSingleton() {
        PrintTools.printInfo("这是懒汉不安全的单例");
    }

    public static LazyNotSafeSingleton getInstance() {
        if (ObjectUtils.isEmpty(instance)) {
            instance = new LazyNotSafeSingleton();
        }
        return instance;
    }
}
