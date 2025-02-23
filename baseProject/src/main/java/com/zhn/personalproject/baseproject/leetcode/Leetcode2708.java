package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode2708 {
    public long maxStrength(int[] nums) {
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        long result = 1;
        Arrays.sort(nums);
        if(nums[0] == 0 && nums[nums.length - 1] == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        while(pointer1 < nums.length && nums[pointer1] < 0){
            result *= nums[pointer1];
            pointer1 += 1;
        }
        while(pointer2 >= 0 && nums[pointer2] > 0){
            result *= nums[pointer2];
            pointer2 -= 1;
        }
        if(result < 0 && pointer1 == 0 && nums[nums.length - 1] == 0){
            return 0;
        }
        if(result < 0){
            result /= nums[pointer1];
        }

        return result;
    }
}
