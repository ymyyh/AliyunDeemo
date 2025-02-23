package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2938 {
    public long minimumSteps(String s) {
        int white = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == '0'){
                white += 1;
            }
        }
        long whiteSum = 0;
        long blackSum = 0;
        for(int i = 0;i < s.length(); ++i){
            if(i < white && s.charAt(i) == '1'){
                blackSum += i;
            }
            if(i >= white && s.charAt(i) == '0'){
                whiteSum += i;
            }
        }

        return whiteSum - blackSum;
    }
}
