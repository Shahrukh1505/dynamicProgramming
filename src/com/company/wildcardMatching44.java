package com.company;

import java.util.Scanner;

public class wildcardMatching44 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.next();
        String p = scn.next();

        System.out.println(isMatch(s,p));

    }
    public static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[n][m] = true;

        for(int i = 0;i<m;i++){
            dp[n][i] = false;
        }

        for(int i = 0;i<n;i++){
            boolean flag = true;
            for(int j = i;j<n;j++){
                if(p.charAt(j) != '*'){
                    flag = false;
                    break;
                }
            }

            if(flag){
                dp[i][m] = true;
            }
        }

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
                    dp[i][j] = dp[i+1][j+1];
                }
                else if(p.charAt(i) == '*'){
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[0][0];
    }

    public static boolean helper(String p, String s, int i, int j){
        if(i == p.length() && j == s.length()){
            return true;
        }

        if(i == p.length() && j < s.length()){
            return false;
        }

        if(i < p.length() && j == s.length()){
            for(int k = i;k<p.length();k++){
                if(p.charAt(k) != '*'){
                    return false;
                }

            }

            return true;
        }

        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
            return helper(p, s, i + 1, j + 1);
        }

        if(p.charAt(i) == '*'){
            return helper(p, s, i+1, j) || helper(p, s, i, j + 1);
        }

        return false;
    }
}
