package com.teavamc.vamcsam.practice.demo.authcode;

/**
 *
 * 获取验证码
 *
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.demo.authcode
 * @date 2020/10/29 15:46
 */
public class AuthCode {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        double randomVal = Math.random() * 9 + 1;
        long code = new Double(randomVal* Math.pow(10, 5)).longValue();
        long end = System.currentTimeMillis();
        System.out.println("get code:" + code + "  ,depends:" + (end - start) + "ms");
    }
}
