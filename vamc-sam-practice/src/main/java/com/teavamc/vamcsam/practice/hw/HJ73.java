package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 测试用例有多组，注意循环输入
 *
 * 输入描述:
 * 输入多行，每行空格分割，分别是年，月，日
 *
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 *                                            失败:返回-1
 */
public class HJ73 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String text = sc.nextLine();
            String[] arr = text.split(" ");
            int day = outDay(Integer.valueOf(arr[0]),
                    Integer.valueOf(arr[1]),
                    Integer.valueOf(arr[2]));
            System.out.println(day);
        }
    }

    // 闰年判断方法 能被 4 和 400 整除, 但不能被 100 整除
    private static int outDay(int year, int month, int day) {
        // 写出所有的月份应有的天数
        int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
        // 判断输入的日期是否有效
        if(year <= 0 ||month <= 0 || month > 12 || day<= 0 || day > Day[month - 1])
            return -1;
        // 判断闰年, 如果是闰年,2 月的天数就是 29
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29 ;
        }
        // 天数
        int sum = 0 ;
        // 天数就是月份天数-1 + 当前月已经过的天数
        for(int i = 0 ; i < month - 1 ; i ++){
            sum += Day[i] ;
        }
        return sum + day;
    }
}
