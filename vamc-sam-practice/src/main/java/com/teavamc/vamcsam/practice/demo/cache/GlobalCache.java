package com.teavamc.vamcsam.practice.demo.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.cache
 * @date 2020/11/6 22:02
 */
public class GlobalCache {
    public static ConcurrentHashMap<String, LocalCache> cache = new ConcurrentHashMap<>();
}
