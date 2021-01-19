package com.teavamc.vamcsam.practice.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * Lily的所有图片按照从小到大的顺序输出
 *
 * 输入
 * Ihave1nose2hands10fingers
 * 输出
 * 0112Iaadeeefghhinnnorsssv
 */
public class HJ34 {

    public static void main(String[] args) {
        // 按优先度: 数字/大写/小写
        // 数字中(0-9) 大小写(a-z)
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] ch=str.toCharArray();
            // 按 asc 码排序就直接用原生排序
            Arrays.sort(ch);
            System.out.println(ch);
        }

    }
}
