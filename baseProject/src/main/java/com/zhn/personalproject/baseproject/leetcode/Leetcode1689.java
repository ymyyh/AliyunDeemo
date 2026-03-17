package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1689 {
    public int minPartitions(String n) {
        int result = 0;
        for(int i = 0;i < n.length(); ++i){
            result = Math.max(result, n.charAt(i) - '0');
        }
        return result;
    }
}
