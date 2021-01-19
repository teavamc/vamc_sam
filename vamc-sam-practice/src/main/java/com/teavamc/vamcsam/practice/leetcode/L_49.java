package com.teavamc.vamcsam.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.leetcode
 * @date 2020/12/14 下午2:34
 */
public class L_49 {

    public static void main(String[] args) {
        String[] text = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(text);
    }

    static long getProduct(String s){
        long res = 1;
        for(int i=0;i<s.length();i++){
            res = s.charAt(i)*res;
        }
        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length==1){
            List<String> item = new ArrayList<>();
            item.add(strs[0]);
            res.add(item);
            return res;
        }
        // 用一个容器来装结果
        Map<Long,List<String>> map = new HashMap<>();
        for(String str:strs){
            Long strVal = getProduct(str);
            List<String> value = map.getOrDefault(strVal,new ArrayList<>());
            value.add(str);
            map.put(strVal,value);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
