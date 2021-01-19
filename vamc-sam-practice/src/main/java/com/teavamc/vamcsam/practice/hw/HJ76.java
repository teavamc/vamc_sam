package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 */
public class HJ76 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            // a1 = ( n -1 ) * n + 1
            StringBuilder sb =new StringBuilder();
            int a1 = input * input - input + 1;
            sb.append(a1);
            for(int i = 1;i<input;i++){
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb.toString());
        }
    }
}
