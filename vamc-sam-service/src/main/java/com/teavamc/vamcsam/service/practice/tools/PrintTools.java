package com.teavamc.vamcsam.service.practice.tools;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice.tools
 * @date 2020/10/22 14:44
 */
public class PrintTools {

    public static void printInfo(Object o){
        System.out.println(JSONObject.toJSON(o));
    }

    public static void printBinaryInteger(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
