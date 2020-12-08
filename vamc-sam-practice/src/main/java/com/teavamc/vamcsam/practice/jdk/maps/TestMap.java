package com.teavamc.vamcsam.practice.jdk.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.jdk.maps
 * @date 2020/11/16 下午2:06
 */
public class TestMap {

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        IdentityHashMap<String,String> identityHashMap = new IdentityHashMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        Hashtable<String,String> hashtable = new Hashtable<>();

    }


}
