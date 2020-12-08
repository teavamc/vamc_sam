package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            // 兔子分成三类 模拟一下就出来了
            int a = 1;
            int b = 0;
            int c = 0;
            int amount = 0;
            while(--input>0){
                c += b;
                b = a;
                a = c;
                amount = a + b + c;
            }
            System.out.println(amount);
        }

    }
}
