package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2748 {
    public int countBeautifulPairs(int[] nums) {
        Map<Integer, Integer> map2 = new HashMap<>();


        int count = 0;
        for(int i = 0;i < nums.length; ++i){
            int a = Integer.toString(nums[i]).charAt(0) - '0';
            for(int j = i + 1;j < nums.length; ++j){
                int b = nums[j] % 10;
                if(gcb(a, b) == 1){
                    count += 1;
                }
            }

        }
        return count;
    }
    public int gcb(int a, int b){
        int c;
        if(a < b){
            c = b;
            b = a;
            a = c;
        }
        if(b == 0 || b == 1){
            return b;
        }
        else{
            a = a % b;
            return gcb(a, b);
        }
    }
}
