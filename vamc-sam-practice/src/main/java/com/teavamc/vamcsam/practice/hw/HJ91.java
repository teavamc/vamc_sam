package com.teavamc.vamcsam.practice.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，
 * 即：只能往右和往下走，不能往左和往上走。
 * <p>
 * 本题含有多组样例输入。
 * 输入描述:
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * <p>
 * 输出描述:
 * 每组样例输出一行结果
 * <p>
 * 输入
 * 2 2
 * 1 2
 * 输出
 * 6
 * 3
 */
public class HJ91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 备忘录容器
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            // 备忘录动态规划
            System.out.println(getRes(map, n, m));
        }
    }

    public static Integer getRes(Map<String, Integer> map, int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }
        String key = n + "" + m;
        if (map.get(key) == null) {
            map.put(key, getRes(map, n - 1, m) + getRes(map, n, m - 1));
        }
        return map.get(key);
    }
}
