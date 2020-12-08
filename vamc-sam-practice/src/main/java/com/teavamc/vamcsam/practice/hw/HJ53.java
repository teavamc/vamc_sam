package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 1
 * 1  1  1
 * 1  2  3  2  1
 * 1  3  6  7  6  3  1
 * 1  4  10 16 19  16 10  4  1
 *
 * 以上三角形的数阵，第一行只有一个数1，
 * 以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 *
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * -----------
 * 杨辉三角变形
 * 注意每一行的规律，每一行有2 * i - 1个数，中间的数位于第i个位置
 * 从第1行开始（而不采用第0行）方便后面的计算
 * map[i][j] = map[i - 1][j - 2] + map[i - 1][j - 1] + map[i - 1][j]
 * 注意若采用上式，在算map[i][1]直接赋值，否则map[i - 1][j - 2]会数组越界
 * 判断第几位是偶数时，只需循环到中间位置即可，因为每一行的数是对称的。
 */
public class HJ53 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            // 找到偶数
            System.out.println(getFirstPlaceEven(n));
        }
    }

    public static int getFirstPlaceEven(int n){
        // 列 : 每一行的长度是 (2 * n) - 1 , 从 1 开始,所以长度是 2 * n
        // 行 : 从 1 开始,所以长度是 n + 1
        int[][] map = new int[n + 1][2*n];
        // 最左最上元素
        map[1][1] = 1;
        // 初始化这个三角形
        for(int i = 2; i <= n; i++){
            // 所有行的第一位是 1
            map[i][1] = 1;
            // 找到规律, 每一位的值为 map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j]
            for(int j = 2; j <= 2 * i - 1; j++)
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j];
        }
        // 第 n 行的中位数是 n, 所以只用遍历到 [i][j] - [i][n] 就能拿到偶数
        for(int i = 1; i <= n; i++)
            if(map[n][i] % 2 == 0)
                return i;
        return -1;
    }

}
