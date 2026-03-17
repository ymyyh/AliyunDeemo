package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1888 {
    public int minFlips(String s) {
        int result = Integer.MAX_VALUE;
        int value0 = 0, value1 = 1, count0 = 0, count1 = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) - '0' != value0){
                count0 += 1;
            }
            if(s.charAt(i) - '0' != value1){
                count1 += 1;
            }
            value0 = 1 - value0;
            value1 = 1 - value1;
        }
        result = Math.min(count0, count1);

        for(int i = 0 ;i < s.length(); ++i){
            if(s.charAt(i) - '0' == 0){
                int temp0 = count0;
                int temp1 = count1;
                count0 = (s.length() - 1) - temp0;
                count1 = (s.length() - 1) - (temp1 - 1);

                if(s.length() % 2 == 0){
                    count0 += 1;
                }else{
                    count1 += 1;
                }

            }else{
                int temp0 = count0;
                int temp1 = count1;
                count1 = (s.length() - 1) - temp1;
                count0 = (s.length() - 1) - (temp0 - 1);

                if(s.length() % 2 == 0){
                    count1 += 1;
                }else {
                    count0 += 1;
                }
            }

            result = Math.min(Math.min(count0, count1), result);
        }

        return result;
    }
}
