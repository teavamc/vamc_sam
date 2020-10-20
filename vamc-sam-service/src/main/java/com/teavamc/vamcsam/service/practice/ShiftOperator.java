package com.teavamc.vamcsam.service.practice;

import com.alibaba.fastjson.JSONObject;

/**
 * 练习一下移位运算符
 *
 * << N  -> 代表✖️ 2 的 N 次方 : 1 << 2 = 1 * 2 * 2 = 4
 * >> N  -> 代表➗ 2 的 N 次方 : 8 >> 2 = 8 ➗ (2 * 2) = 2
 * >>> 无符号右移
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.service.practice
 * @date 2020/10/20 11:22
 */
public class ShiftOperator {

    public static void main(String[] args) {
        int temp = 10;
        int temp_one = temp >> 4;
        printBinaryInteger(temp_one);
        int temp_two = temp << 4;
        printBinaryInteger(temp_two);
        int temp_three = temp >>> 4;
        printBinaryInteger(temp_three);
    }


    static void printInfo(Object o){
        System.out.println(JSONObject.toJSON(o));
    }

    static void printBinaryInteger(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
