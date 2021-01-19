package com.teavamc.vamcsam.practice.hw;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 *
 * 假设两个字符串分别为s和t，s[i]和t[j]分别表示其第i和第j个字符(字符顺序从0开始)，
 * 再令L[i, j]表示以s[i]和s[j]为结尾的相同子串的最大长度。
 * 应该不难递推出L[i, j]和L[i+1,j+1]之间的关系，因为两者其实只差s[i+1]和t[j+1]这一对字符。
 * 若s[i+1]和t[j+1]不同，那么L[i+1, j+1]自然应该是0，因为任何以它们为结尾的子串都不可能完全相同；
 * 而如果s[i+1]和t[j+1]相同，那么就只要在以s[i]和t[j]结尾的最长相同子串之后分别添上这两个字符即可，这样就可以让长度增加一位。
 * 合并上述两种情况，也就得到L[i+1,j+1]=(s[i+1]==t[j+1]?L[i,j]+1:0)这样的关系。
 *
 * L[i+1,j+1] = ( s[i+1]==t[j+1] ? L[i,j]+1 : 0)
 *
 * 输入描述:
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述:
 * 输出一个整数，代表最大公共子串的长度
 */
public class HJ75 {

//    int lcs(string a, string b)
//    {
//        int maxLen = 0;
//        a.insert(0, 1, ' ');
//        b.insert(0, 1, ' ');
//        int n = a.size(), m = b.size();
//        int dp[n][m];
//        for(int i = 0; i < n; i++) dp[i][0] = 0;
//        for(int j = 0; j < m; j++) dp[0][j] = 0;
//        for(int i = 1; i < n; i++)
//        {
//            for(int j = 1; j < m; j++)
//            {
//                if(a[i] == b[j]) {
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                    maxLen = max(maxLen, dp[i][j]);
//                } else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return maxLen;
//    }
//
//    int main()
//    {
//        string a, b;
//        while(cin >> a >> b)
//        {
//            cout << lcs(a, b) << endl;
//        }
//        return 0;
//    }

    public static String lcs(String s1,String s2){
        return null;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input_1 = sc.nextLine();
            String input_2 = sc.nextLine();


        }
    }


}
