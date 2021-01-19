package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入一个偶数
 * <p>
 * 输出描述:
 * 输出两个素数
 * <p>
 * 输入
 * 20
 * 输出
 * 7
 * 13
 */
public class HJ60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] res = new int[2];
            // 其中一个素数肯定在其中一边上,所以只遍历到 n/2
            for (int i = 1; i <= n / 2; i++) {
                // 这个可以看做为是双指针
                // 找到素数对不停止,越接近中间,差越小,所以 for 一遍之后始终取最小的
                if (isPrime(i) && isPrime(n - i)) {
                    res[0] = i;
                    res[1] = n - i;
                }
            }
            System.out.println(res[0]);
            System.out.println(res[1]);
        }
        sc.close();
    }

    /**
     * 判断这个数字是不是素数
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        // 从 2 - len-1 如果能被整除就不是素数
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
