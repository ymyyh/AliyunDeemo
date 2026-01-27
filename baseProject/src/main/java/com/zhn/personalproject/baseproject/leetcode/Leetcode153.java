package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left < right){
            if(nums[left] < nums[right]){
                return nums[left];
            }
            if(nums[mid] < nums[left]){
                right = mid;
            }else{
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return nums[left];
    }
}
