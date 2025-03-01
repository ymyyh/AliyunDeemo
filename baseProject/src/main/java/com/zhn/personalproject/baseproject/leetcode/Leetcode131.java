package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i < s.length(); ++i){
            dp[i][i] = 1;
        }
        int length = s.length();
        for(int i = length - 1;i >= 0; i--){
            for(int j = i + 1;j < length; j++){
                if(s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1] == 1)){
                    dp[i][j] = 1;
                }
            }
        }
        List<String> record = new ArrayList<>();
        dfs(0, 0, record, s, dp);
        return result;
    }

    public void dfs(int start, int end, List<String> record, String s, int[][] dp){
        if(end == s.length()){
            if(start == end){
                result.add(new ArrayList<>(record));
            }
            return;
        }
        if(dp[start][end] == 1){
            record.add(s.substring(start, end + 1));
            dfs(end + 1, end + 1, record, s, dp);
            record.remove(record.size() - 1);
        }
        dfs(start, end + 1, record, s, dp);
            return;
    }
}
