package com.teavamc.vamcsam.practice.labuladong;

import java.util.List;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.labuladong
 * @date 2020/12/9 上午11:51
 */
public class DpPractice {

    /**
     * 备忘录递归
     * 自顶上下法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param N
     * @return
     */
    int fib(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[]{N + 1};
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 如果没有计算过就先计算好再放进去
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        // 已经计算过
        return memo[n];
    }

    /**
     * 自底向上法
     * 不用递归,用遍历迭代
     *
     * @param N
     * @return
     */
    int fib2(int N) {
        if (N < 1) return 0;
        // 边界
        if (N == 1 || N == 2) return 1;
        // dp table
        int[] dp = new int[]{N + 1};
        // 最优子结构
        dp[1] = dp[2] = 1;
        // 循环即可
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N];
    }

    /**
     * 自底向上法
     * 转换方程式 f(n) = f(n-1) + f(n-2)
     * 其实只用到了两个元素, 所以空间复杂度可以压缩到常数 O(1)
     *
     * @param n
     * @return
     */
    int fib3(int n) {
        if (n < 1) return 0;
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }


}
