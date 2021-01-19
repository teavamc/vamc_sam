package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 功能:等差数列 2，5，8，11，14。。。。
 * 输入:正整数N >0
 * 输出:求等差数列前N项和
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 * 输入描述:
 * 输入一个正整数。
 * 输出描述:
 * 输出一个相加后的整数。
 */
public class HJ100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 思路：等差数列求和公式
            // 前n项和: Sn = （a1 + an）*n/2
            // 第 n 项：an = a1 + (n - 1) * 3(公差);
            int ip = sc.nextInt();
            System.out.println((1 + 3 * ip) * ip / 2);

        }
    }
}
