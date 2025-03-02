package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode100527 {
    int max = Integer.MIN_VALUE;
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        if(nums.length < k) {
            return -1;
        }else if(nums.length == k){
            for(int num : nums){
                max = Math.max(max, num);
            }
        }else if(k == 1){
            for(int num : nums){
                if(map.get(num) == 1) {
                    max = Math.max(max, num);
                }
            }
        }else{
            if(map.get(nums[0]) == 1){
                max = Math.max(max, nums[0]);
            }
            if(map.get(nums[nums.length - 1]) == 1){
                max = Math.max(max, nums[nums.length - 1]);
            }
        }

        if(max == Integer.MIN_VALUE){
            return -1;
        }else{
            return max;
        }
    }
}
