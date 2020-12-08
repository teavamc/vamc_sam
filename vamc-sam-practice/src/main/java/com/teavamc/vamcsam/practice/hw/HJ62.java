package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 */
public class HJ62 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int count = 0;
            // 转二进制字符串
            String str = Integer.toBinaryString(n);
            // 转数组
            char[] cha = str.toCharArray();
            // 遍历数组
            for(char c :cha){
                if(c=='1'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
