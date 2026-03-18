package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode3713 {
    public int longestBalanced(String s) {
        Map<Integer, Integer> record = new HashMap<>();
        int result = 0;
        for(int i = 0;i < s.length(); ++i){
            for(int j = i;j < s.length(); ++j){
                record.put(s.charAt(j) - 'a', record.getOrDefault(s.charAt(j) - 'a', 0) + 1);
                if(new HashSet<>(record.values()).size() == 1){
                    result = Math.max(result, j - i + 1);
                }
            }
            record.clear();
        }
        return  result;
    }
}
