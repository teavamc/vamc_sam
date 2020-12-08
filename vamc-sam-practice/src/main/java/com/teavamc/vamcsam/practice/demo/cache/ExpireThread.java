package com.teavamc.vamcsam.practice.demo.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.cache
 * @date 2020/11/6 22:03
 */
public class ExpireThread implements Runnable {


    @Override
    public void run() {
        // 没间隔 10 秒钟清理一次
        while (true){
            try{
                TimeUnit.SECONDS.sleep(10);
                expireCache();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 检查是否存在过期的 key,如果存在就删除,remove
     */
    private void expireCache(){
        System.out.println("检查缓存过期");
        for (String key:GlobalCache.cache.keySet()){
            LocalCache localCache = GlobalCache.cache.get(key);
            //
            long timeoutTime = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - localCache.getCreateDateTime());
            if (localCache.getExpireDateTime() > timeoutTime){
                // 没过期
                continue;
            }
            // 过期了,清除缓存
            GlobalCache.cache.remove(key);
        }
    }
}
