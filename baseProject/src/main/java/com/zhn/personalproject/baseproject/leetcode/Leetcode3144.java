package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3144 {
    Map<String, Integer> totalRecord = new HashMap<>();
    public int minimumSubstringsInPartition(String s) {
        if(s.length() == 1){
            return 1;
        }
        if(totalRecord.containsKey(s)){
            return totalRecord.get(s);
        }
        if(checkArray(s)){
            totalRecord.put(s, 1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < s.length(); ++i){
            min = Math.min(min, minimumSubstringsInPartition(s.substring(0, i)) + minimumSubstringsInPartition(s.substring(i)));
        }
        totalRecord.put(s, min);
        return min;
    }

    public boolean checkArray(String s){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
            max = Math.max(max, map.get(s.charAt(i)));
        }
        if(max * map.size() == s.length()) {
            return true;
        }
        else{
            return false;
        }
    }
}