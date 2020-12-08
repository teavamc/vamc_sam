package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;

/**
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\ d:\，
 *
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\
 * 参数4: 字符串d:\
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 * 解析规则：
 * 1.参数分隔符为空格
 *
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。
 * 比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，
 * 第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 *
 * 3.参数不定长
 *
 * 4.输入由用例保证，不会出现不符合要求的输入
 */
public class HJ74 {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        // 拿到输入字符串
        String str = sc.nextLine();
        // 动态字符串对象
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++){
            // 如果是 " 就跳过
            if (str.charAt(i) == '\"'){
                quotaNum++;
                continue;
            }
            // 如果字符不是空格就记录元素
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
                // 如果引号是 2 的倍数就加分段标识
            } else if (quotaNum % 2 == 0){
                sb.append('\n');
                len++;
            }else {
                // 如果是空格就记录空格
                sb.append(' ');
            }
        }

        System.out.println(len+1);
        System.out.println(sb.toString());

    }
}
