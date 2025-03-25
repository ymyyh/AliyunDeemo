package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2255 {
    public int countPrefixes(String[] words, String s) {
        Set<String> strSet = new HashSet<String>();
        for(int i = 1;i < s.length(); ++i){
            strSet.add(s.substring(0, i));
        }
        int result = 0;
        for(String str : words){
            if(strSet.contains(str)){
                result += 1;
            }
        }

        return result;
    }
}
