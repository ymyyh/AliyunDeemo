package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode416 {
    public boolean canPartition(int[] nums){
        Set<Integer> dp = new HashSet<>();
        int sum = 0;
        for(int i = 0;i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        sum /= 2;
        Set<Integer> tempSet = new HashSet<>();
        for(int i = 0;i < nums.length; ++i){

            if(nums[i] == sum){
                return true;
            }

            tempSet = new HashSet<>(dp);
            for(int num : dp){
                if(num + nums[i] < sum){
                    tempSet.add(num + nums[i]);
                }else if(num + nums[i] == sum){
                    return true;
                }
            }
            tempSet.add(nums[i]);
            dp = tempSet;
        }
        return false;
    }
}
