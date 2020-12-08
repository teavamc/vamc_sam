package com.teavamc.vamcsam.practice.demo.cache;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.cache
 * @date 2020/11/6 22:11
 */
public class CacheUtils {

    /**
     * 添加新的缓存
     * @param key
     * @param value
     * @param expire
     */
    public void put(String key,Object value,long expire){
        if (StringUtils.isBlank(key)){
            return;
        }
        // 判断 key 是否存在 , 存在就更新
        if (GlobalCache.cache.containsKey(key)){
            LocalCache localCache = GlobalCache.cache.get(key);
            localCache.setValue(value);
            localCache.setCreateDateTime(System.currentTimeMillis());
            localCache.setLastUseDateTime(System.currentTimeMillis());
            localCache.setExpireDateTime(expire);
            localCache.setUseCount(localCache.getUseCount() + 1);
            return;
        }
        // 不存在就创建
        LocalCache localCache = new LocalCache();
        localCache.setKey(key);
        localCache.setValue(value);
        localCache.setCreateDateTime(System.currentTimeMillis());
        localCache.setLastUseDateTime(System.currentTimeMillis());
        localCache.setExpireDateTime(expire);
        localCache.setUseCount(1);
        GlobalCache.cache.put(key, localCache);
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public Object get(String key){
        if (StringUtils.isBlank(key)) {
            return null;
        }
        if (GlobalCache.cache.isEmpty()){
            return null;
        }
        if (!GlobalCache.cache.containsKey(key)){
            return null;
        }
        LocalCache localCache = GlobalCache.cache.get(key);
        if (localCache == null){
            return null;
        }
        // 判断过期
        long timeOut = System.currentTimeMillis() - localCache.getCreateDateTime();
        if (timeOut >= localCache.getExpireDateTime()){
            // 清除缓存
            GlobalCache.cache.remove(key);
            return  null;
        }
        localCache.setLastUseDateTime(System.currentTimeMillis());
        localCache.setUseCount(localCache.getUseCount() + 1);
        return localCache.getValue();

    }
}
