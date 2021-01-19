package com.teavamc.vamcsam.practice.hw;

import java.util.Scanner;
import java.util.Stack;

/**
 * 倒序输出
 */
public class HJ106 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String input = sc.nextLine();
//            for(int i = input.length()-1;i>=0;i--){
//                System.out.print(input.charAt(i));
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.nextLine();
            char[] str_arr = input.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char ch : str_arr){
                stack.add(ch);
            }
            while (!stack.empty()){
               System.out.print(stack.pop());
            }
        }
    }
}
