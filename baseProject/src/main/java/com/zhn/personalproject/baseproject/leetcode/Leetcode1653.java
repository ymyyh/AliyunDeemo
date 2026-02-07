package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1653 {
    public int minimumDeletions(String s) {
        int[] record1 = new int[s.length() + 1];
        int[] record2 = new int[s.length() + 1];

        record1[0] = 0;
        record2[s.length()] = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == 'b') {
                record1[i + 1] = record1[i] + 1;
            }else{
                record1[i + 1] = record1[i];
            }
        }
        for(int i = s.length() - 1;i >= 0; --i){
            if(s.charAt(i) == 'a') {
                record2[i] = record2[i + 1] + 1;
            }else{
                record2[i] = record2[i + 1];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0;i <= s.length(); ++i){
            result = Math.min(result, record1[i] + record2[i]);
        }

        return result;
    }
}
