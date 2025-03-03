package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode1278 {
    public int palindromePartition(String s, int k) {
        int[][] dp  = new int[s.length() + 1][k + 1];
        for(int i = 1;i <= s.length(); ++i){
            Arrays.fill(dp[i], 10000000);
        }
        dp[0][0] = 0;

        for(int i = 1; i <= s.length(); ++i){
            for(int j = 1; j <= Math.min(k, i); ++j){
                if(j == 1){
                    dp[i][j] = checkCount(0, i - 1, s);
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int t = i - 1;t >= j - 1; --t){
                        min = Math.min(min, dp[t][j - 1] + checkCount(t, i - 1, s));
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[s.length()][k];
    }

    public int checkCount(int start, int end, String s){
        int count = 0;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                count += 1;
            }
            start += 1;
            end -= 1;
        }
        return count;
    }
}
