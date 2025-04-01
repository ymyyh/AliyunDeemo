package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2278 {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == letter){
                count += 1;
            }
        }
        return count / s.length();
    }
}
