package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode1745 {
    boolean result = false;
    public boolean checkPartitioning(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i < s.length(); ++i){
            Arrays.fill(dp[i], 0);
            dp[i][i] = 1;
        }

        for(int i = s.length() - 1;i >= 0; --i){
            for(int j = i + 1;j < s.length(); ++j){
                if(s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 0;i < s.length() - 1; ++i){
            for(int j = i;j < s.length(); ++j){
                if(dp[0][i] == 1 && dp[i + 1][j] == 1 && dp[j + 1][s.length() - 1] == 1){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
}
