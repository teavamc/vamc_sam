package com.teavamc.vamcsam.practice.demo.cache;

import lombok.Data;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.cache
 * @date 2020/11/6 21:56
 */
@Data
public class LocalCache implements Comparable<LocalCache> {

    // key
    private Object key;

    // value
    private Object value;

    // 创建时间
    private long createDateTime;

    // 最后使用时间
    private long lastUseDateTime;

    // 过期时间
    private long expireDateTime;

    // 使用次数
    private Integer useCount;


    @Override
    public int compareTo(LocalCache o) {
        return useCount.compareTo(o.useCount);
    }
}
