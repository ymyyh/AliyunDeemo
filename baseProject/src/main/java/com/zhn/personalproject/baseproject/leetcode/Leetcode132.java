package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode132 {
    int totalCount = Integer.MAX_VALUE;
    int[] minCount;
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i < s.length(); ++i){
            dp[i][i] = 1;
        }

        for(int i = s.length() - 1;i >= 0; --i){
            for(int j = i + 1;j < s.length(); ++j){
                if(s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                }
            }
        }

        minCount = new int[dp.length];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        dfs(0, 0, dp);
        return totalCount;
    }

    public void dfs(int pos, int count, int[][] dp){
        if(count >= minCount[pos]){
            return;
        }

        if(pos == dp.length){
            totalCount = Math.min(totalCount, count);
            return;
        }
        minCount[pos] = count;
        for(int i = pos;i < dp.length; ++i){
            if(dp[pos][i] == 1){
                dfs(i + 1, count + 1, dp);
            }
        }
    }
}
