package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left < right){
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        return left;
    }
}
