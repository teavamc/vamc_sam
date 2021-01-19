package com.teavamc.vamcsam.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package com.teavamc.vamcsam.practice.leetcode
 * @date 2020/12/11 下午2:51
 */
public class L_649 {

    // DRRDRDRDRDDRDRDR
    // DRRRRDDD
    // DRRR
    // RR

    public static void main(String[] args) {
        String senate = "DRRDRDRDRDDRDRDR";
        String res = new L_649().predictPartyVictory(senate);
        System.out.println(res);
    }

    public String predictPartyVictory(String senate) {

        int r_num = 0;
        int d_num = 0;
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R' ){
                r_num++;
            }else{
                d_num++;
            }
        }


        int[] pre_arr = new int[senate.length()];

        int len = senate.length()-1;
        int index = 0;
        boolean get;

        while(r_num!=0&&d_num!=0){
            get = false;
            if(pre_arr[index] != -1){
                if(senate.charAt(index) == 'R' ){
                    // 开始 D
                    if(d_num<1){
                        return "Radiant";
                    }
                    // 从本字符后面开始找,如果没有再从头开始
                    for(int i = index;i< senate.length();i++){
                        if(senate.charAt(i) == 'D' && pre_arr[i]==0){
                            pre_arr[i] = pre_arr[i] -1;
                            d_num--;
                            get = true;
                            break;
                        }
                    }
                    if (!get && index!=0){
                        for(int i = 0;i< index;i++){
                            if(senate.charAt(i) == 'D' && pre_arr[i]==0){
                                pre_arr[i] = pre_arr[i] -1;
                                d_num--;
                                break;
                            }
                        }
                    }
                }else{
                    // 寻找 R
                    if(r_num<1){
                        return "Dire";
                    }
                    // 从本字符后面开始找,如果没有再从头开始
                    for(int i = index;i< senate.length();i++){
                        if(senate.charAt(i) == 'R' && pre_arr[i]==0){
                            pre_arr[i] = pre_arr[i] -1;
                            r_num--;
                            get = true;
                            break;
                        }
                    }
                    if (!get && index!=0){
                        for(int i = 0;i< index;i++){
                            if(senate.charAt(i) == 'R' && pre_arr[i]==0){
                                pre_arr[i] = pre_arr[i] -1;
                                r_num--;
                                break;
                            }
                        }
                    }
                }
            }
            if(index!=len){
                index++;
            }else{
                index=0;
            }
        }
        if(r_num==0){
            return "Dire";
        }else {
            return "Radiant";
        }

    }


}