package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2712 {
    public long minimumCost(String s) {
        long result = 0;
        for(int i = 1;i < s.length(); ++i){
            if(s.charAt(i - 1) != s.charAt((i))){
                result += Math.min(i, s.length() - i);
            }
        }
        return result;
    }
}
