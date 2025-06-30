package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        Set<Integer> posSet = new HashSet<>();
        posSet.add(0);
        int currentRecord = groups[0];
        for(int i = 1;i < groups.length; ++i){
            if(groups[i] != currentRecord){
                posSet.add(i);
                currentRecord = groups[i];
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = 0;i < words.length; ++i){
            if(posSet.contains(i)){
                result.add(words[i]);
            }
        }
        return result;
    }
}
