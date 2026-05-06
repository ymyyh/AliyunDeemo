package com.zhn.personalproject.baseproject.leetcode;


import java.util.HashSet;
import java.util.Set;

public class Leetcode1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<Long> record = new HashSet<>();
        long max = 0, temp = 0;
        for(String num : nums){
            temp = Long.parseLong(num, 2);
            record.add(temp);
            max = Math.max(max, temp);
        }
        for(long i = 0;i <= max + 1; ++i){
            if(!record.contains(i)){
                return  String.format("%" + nums[0].length() + "s", Long.toBinaryString(i)).replace(' ', '0');
            }
        }
        return "";
    }
}
