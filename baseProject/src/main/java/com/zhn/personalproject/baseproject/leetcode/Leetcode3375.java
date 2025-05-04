package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3375 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num > k){
                set.add(num);
            }else if(num < k){
                return -1;
            }
        }
        return set.size();
    }
}
