package com.teavamc.vamcsam.practice.hw;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入两个用字符串表示的整数，求它们所表示的数之和。
 * 字符串的长度不超过10000。
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 *
 * 输出描述:
 * 输出求和后的结果
 *
 * 输入
 * 9876543210
 * 1234567890
 *
 * 输出
 * 11111111100
 */
public class HJ57 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            BigInteger bi1 = new BigInteger(s1);
            BigInteger bi2 = new BigInteger(s2);
            System.out.println((bi1.add(bi2)));
        }
    }
}
