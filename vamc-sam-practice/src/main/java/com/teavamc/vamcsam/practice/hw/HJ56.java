package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.hw
 * @date 2020/12/14 下午10:45
 */
public class HJ56 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int count = 0;
            // 从 2 开始
            for (int i = 2; i <= a; i++) {
                // 如果是完全数就++
                if (isCompelectNum(i)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static boolean isCompelectNum(int num) {
        int sum = 0;
        // 从 2 遍历到 num,找到所有能够被整除的数
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        // 因为 1 是所有数字的公约数
        if (sum + 1 == num) {
            return true;
        }
        return false;
    }


}
