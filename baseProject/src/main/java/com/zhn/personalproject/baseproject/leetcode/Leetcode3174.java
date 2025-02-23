package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3174 {
    public String clearDigits(String s) {
        int[] record = new int[s.length()];
        int pointer = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                record[i] = 1;

                pointer = i - 1;
                while (pointer >= 0 && ((s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9')
                        || (s.charAt(pointer) < '0' || s.charAt(pointer) > '9') && record[pointer] == 1)) {
                    pointer -= 1;
                }
                if (pointer >= 0) {
                    record[pointer] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < record.length; ++i){
            if(record[i] == 0){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
