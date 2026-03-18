package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1758 {
    public int minOperations(String s) {
        int tag1 = 0;
        int tag2 = 1;

        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) - '0' != tag1){
                count1 += 1;
            }
            if(s.charAt(i) - '0' != tag2){
                count2 += 1;
            }

            tag1 = 1 - tag1;
            tag2 = 1 - tag2;
        }

        return Math.min(count1, count2);
    }
}
