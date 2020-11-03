package com.teavamc.vamcsam.practice.leetcode;

import java.util.*;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.leetcode
 * @date 2020/10/29 20:25
 */
public class l_20 {

    private final static Map<Character,Character> kuohaoMap = new HashMap<>();
    static void initMap(){
        kuohaoMap.put('}','{');
        kuohaoMap.put(']','[');
        kuohaoMap.put(')','(');
    }

    private static boolean match(String s){
        if (s == null){
            return true;
        }
        initMap();
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (kuohaoMap.containsValue(c)){
                stack.add(c);
            }else if (kuohaoMap.containsKey(c)){
                if (stack.size() != 0 && kuohaoMap.get(c).equals(stack.peek())){
                    stack.pop();
                }else {
                    stack.add(c);
                }
            }
        }

        if (stack.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(match("()"));
    }


}
