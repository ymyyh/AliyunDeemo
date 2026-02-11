package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode3634 {
    public int minRemoval(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] * k >= nums[nums.length - 1]){
                result = Math.min(result, i);
                break;
            }
            int pos = divide1(nums, nums[i] * k);
            result = Math.min(result, (nums.length - 1 - pos) + i);
        }

        for(int i = nums.length - 1;i >= 0 ; --i){
            if(nums[0] * k >= nums[i]){
                result = Math.min(result, nums.length - i - 1);
                break;
            }
            int pos = divide2(nums, Math.ceilDiv(nums[i], k));
            result = Math.min(result, pos + 1 + (nums.length - i - 1));
        }

        return result;
    }

    public int divide1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }
        return right;
    }

    public int divide2(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }
        return right;
    }
}
