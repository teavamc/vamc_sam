package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
 * 本题输入含有多组数据
 * 输入描述:
 * 第一行输入待截取的字符串
 * 第二行输入一个正整数k，代表截取的长度
 *
 * 注意:中文占用两个字符/英文是一个字符
 *
 * 输出描述:
 * 截取后的字符串
 *
 * abABCcDEF
 * 6
 *
 * abABCc
 */
public class HJ46 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        while (sc.hasNext()) {
            String str=sc.next();
            int num=sc.nextInt();
            // 字符串转字符数组
            char[] arr=str.toCharArray();
            // 用于有效字符的边界统计
            int temp=0;
            // 真实的截取下标
            int i=0;
            while (temp <num) {
                // 汉字占位两个字符
                if (arr[i] > 128) {
                    temp+=2;
                }else {
                    temp++;
                }
                // 如果有效字符小于目标字符数,下标++
                if (temp<=num)
                    i++;
            }
            System.out.println(str.substring(0,i));

        }

//        while(sc.hasNext()){
//            String input = sc.nextLine();
//            int len = sc.nextInt();
//            System.out.println(input.substring(0,len));
//        }
    }

}
