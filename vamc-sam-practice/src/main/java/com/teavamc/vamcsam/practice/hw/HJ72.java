package com.teavamc.vamcsam.practice.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * <p>
 * 详细描述：
 * 接口说明
 * 原型：
 * int GetResult(vector &list)
 * 输入参数：
 * 无
 * <p>
 * 输出参数（指针指向的内存区域保证有效）：
 * list  鸡翁、鸡母、鸡雏组合的列表
 * <p>
 * 返回值：
 * -1 失败
 * 0 成功
 * <p>
 * <p>
 * 设鸡翁(x)，鸡母(y)，鸡雏(z):
 * 5*x+3*y+z/3=100;
 * x=4*z/3-100
 * x+y+z=100;
 * y=200-7*z/3
 * <p>
 * 需满足条件：x>=0,y>=0,z>=0&&(z%3==0)
 * <p>
 * 代入上式x,y表达式，可得75<=z<=600/7
 * 最终：75<=z<=85
 */
public class HJ72 {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        // i 鸡翁 , j 鸡母, k 鸡雏
        // 穷举法
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                int k = 100 - i - j;
                // 如果符合要求就拿出
                if (k % 3 == 0 && 5 * i + 3 * j + k / 3 == 100) {
                    s.add(i + " " + j + " " + k);
                }
            }
        }
        for (String ss : s) {
            System.out.println(ss);
        }
    }


}
