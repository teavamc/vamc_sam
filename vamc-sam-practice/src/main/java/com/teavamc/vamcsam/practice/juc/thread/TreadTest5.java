package com.teavamc.vamcsam.practice.juc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.juc.thread
 * @date 2020/11/4 13:43
 */
public class TreadTest5 {

    // 对象
    static TreadObject object = new TreadObject();

    // 缓存数据
    static Map<String,String> map = new HashMap<>();


    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("[ready]对象状态是 : " + object.getState());
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            object.setState(1);
            System.out.println("[updated]对象状态是 : " + object.getState());
        }).start();

        new Thread(()->{
            System.out.println("[ready]对象状态是 : " + object.getState());
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            object.setState(2);
            System.out.println("[updated]对象状态是 : " + object.getState());
        }).start();

    }

    public void testLockSomething(){
        Lock lock = new ReentrantLock();
        lock.lock();
    }

    /**
     * 放值到 map 里面
     */
    public static void putSomething(){
        try{
            String randomStr = buildRandomValue();
            int begin = 0;
            String keySplit = randomStr.substring(0,2);
            if (Objects.isNull(map.get(keySplit))){
                map.put(keySplit,buildRandomValue());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 从 map 拿值
     * @param str
     * @return
     */
    public static String getSomething(String str){
        String result = null;
        try {
            result = map.get(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String buildRandomValue(){
        Character[] chars = {'a','b','c','d','e','!','@','#','$','%'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<5;i++){
            Random random = new Random(10);
            Character c = chars[random.nextInt()];
            sb.append(c);
        }
        return sb.toString();
    }


}
