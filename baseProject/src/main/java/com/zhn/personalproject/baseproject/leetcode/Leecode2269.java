package com.zhn.personalproject.baseproject.leetcode;

public class Leecode2269 {
    public int divisorSubstrings(int num, int k) {
        int tempInt = 0;
        int count = 0;
        String numStr = Integer.toString(num);
        for(int i = 0;i <= numStr.length() - k; ++i){
            tempInt = Integer.parseInt(numStr.substring(i, i + k));
            if(tempInt != 0 && num % tempInt == 0){
                count++;
            }
        }
        return count;
    }
}
