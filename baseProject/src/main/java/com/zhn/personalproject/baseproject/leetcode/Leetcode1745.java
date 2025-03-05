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

        for(int i = s.length() - 1;i >= 0; ++i){
            for(int j = i + 1;j < s.length(); ++i){
                if(s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1] == 1)){
                    dp[i][i] = 1;
                }
            }
        }

        dfs(0, dp, 3);
        return result;
    }

    public void dfs(int pos, int[][] dp, int count){
        if(result == true){
            return;
        }
        if(count == 0 && pos == dp.length){
            result = true;
            return;
        }
        if(count <= 0 || pos >= dp.length){
            return;
        }

        for(int i = pos;i < dp.length; ++i){
            if(dp[pos][i] == 1){
                dfs(i + 1, dp, count - 1);
            }
        }
        return;

    }
}
