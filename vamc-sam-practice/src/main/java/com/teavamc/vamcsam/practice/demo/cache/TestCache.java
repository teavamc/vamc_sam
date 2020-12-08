package com.teavamc.vamcsam.practice.demo.cache;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.cache
 * @date 2020/11/6 23:51
 */
public class TestCache {
    public static void main(String[] args) {
        CacheUtils utils = new CacheUtils();
        utils.put("hello","isMe",1000000);
        String cacheValue = String.valueOf(utils.get("hello"));
        System.out.println(cacheValue);
    }
}
