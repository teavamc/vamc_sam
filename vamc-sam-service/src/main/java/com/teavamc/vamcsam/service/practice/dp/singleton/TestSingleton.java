package com.teavamc.vamcsam.service.practice.dp.singleton;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.dp.singleton
 * @date 2020/10/29 11:53
 */
public class TestSingleton {

    public static void main(String[] args) {
        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        LazySafeSingleton lazySafeSingleton = LazySafeSingleton.getInstance();
        LazyNotSafeSingleton lazyNotSafeSingleton = LazyNotSafeSingleton.getInstance();
    }
}
