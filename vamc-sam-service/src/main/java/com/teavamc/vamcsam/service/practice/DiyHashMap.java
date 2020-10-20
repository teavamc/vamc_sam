package com.teavamc.vamcsam.service.practice;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 自己仿写 hashmap
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.helper
 * @date 2020/10/19 15:50
 */
public class DiyHashMap {

    public static void main(String[] args) {

        // 初始化一组字符串
        // 随机生成
        List<String> list = randomInputElementList(100);

        // 定义要存放的数组
        String[] tab = new String[8];

        // 循环存放
        for (String key : list) {
            // 计算索引位置
            // 1 - 拿到属性值的 hash 值 (hash 值数据格式是 int, 范围是 -21 亿 ~ 21 亿)
            // 2 - 与 数组长度-1 的值, 按位与 & 运算 ,都 1 取 1
            int idx = key.hashCode() & (tab.length - 1);

            System.out.println(String.format("key值=%s Idx=%d", key, idx));

            if (null == tab[idx]) {
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx] + "->" + key;
        }

        // 输出测试结果
        System.out.println(JSONObject.toJSONString(tab));
    }

    /**
     * 随机插入元素
     *
     * @param pre
     * @param size
     * @return
     */
    public String[] randomInputElement(String[] pre,int size){
        size = ObjectUtils.defaultIfNull(size,8);
        Random random = new Random(10);
        int layer = 0;
        while (layer < size){
            StringBuilder tempVal = new StringBuilder();
            for (int i=0 ; i<10;i++){
                int finalVal = random.nextInt() & 7;
                tempVal.append(finalVal);
            }
            // 如果冲突就放在后面
            if (null == pre[layer]){
                pre[layer] = tempVal.toString();
                continue;
            }
            pre[layer] = pre[layer] +"->"+tempVal.toString();
            layer++;
        }
        return pre;
    }

    /**
     * 随机插入元素
     *
     * @return
     */
    public static List<String> randomInputElementList(int size){
        List<String> list = new ArrayList<>();
        size = ObjectUtils.defaultIfNull(size,8);
        Random random = new Random(10);
        int layer = 0;
        while (layer < size){
            StringBuilder tempVal = new StringBuilder();
            for (int i=0 ; i<10;i++){
                int finalVal = random.nextInt() & 7;
                tempVal.append(finalVal);
            }
            list.add(tempVal.toString());
            layer++;
        }
        return list;
    }

//    @Test
//    public void testHashCollision(){
//        List<String> preValCol = randomInputElementList(100000);
//
//    }
}
