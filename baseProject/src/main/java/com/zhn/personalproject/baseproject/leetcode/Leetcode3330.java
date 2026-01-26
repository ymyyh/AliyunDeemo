package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3330 {
    public int possibleStringCount(String word) {
        int result = 1;
        int record = 0;
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i) == word.charAt(i-1)){
                record++;
            }else{
                result += record - 1;
                record = 1;
            }
        }
        result += record - 1;
        return result;
    }
}
