package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 给一个字符串,判断大写字母的个数
 */
public class HJ84 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ip = sc.nextLine();
            char[] chars = ip.toCharArray();
            int count = 0;
            for(char c:chars){
                if(c >= 'A' && c <= 'Z'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
