package com.company;

import java.util.Scanner;

//https://leetcode.com/problems/shortest-common-supersequence/
public class shortestsupersequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();

        System.out.println(shortestCommonSupersequence(s, p));

    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        //dp[i][j] -> lcs of str1(i,n) str2(j, m)

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }


         for(int i = 0;i<dp.length;i++){
             for(int j = 0;j<dp[0].length;j++){
                 System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }

        int i = 0;
        int j = 0;

        String res = "";

        while(i < n && j < m){
            if(str1.charAt(i) == str2.charAt(j)){
                res += str1.charAt(i);
                i++;
                j++;
            }
            else if(dp[i+1][j] > dp[i][j+1]){
                res += str1.charAt(i);
                i++;
            }
            else{
                res += str2.charAt(j);
                j++;
            }
        }

        while(i < str1.length()){
            res += str1.charAt(i);
            i++;
        }

        while(j < str2.length()){
            res += str2.charAt(j);
            j++;
        }
        return res;
    }

    public static int lcs(String s, String p, int i, int j){
        if(i == s.length() || j == p.length()){
            return 0;
        }



        if(s.charAt(i) == p.charAt(j)){
            return 1 + lcs(s, p, i + 1, j + 1);
        }


        return Math.max(lcs( s, p, i + 1, j),lcs(s, p, i, j+1));
    }
}
