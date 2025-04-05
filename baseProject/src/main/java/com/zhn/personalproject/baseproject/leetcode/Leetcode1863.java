package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1863 {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        dfs(0, nums, 0);
        return result;
    }
    public void dfs(int pos, int[] nums, int temp){
        if(pos >= nums.length){
            result += temp;
            return;
        }
        dfs(pos + 1, nums, temp ^ nums[pos]);
        dfs(pos + 1, nums, temp);
        return;
    }
}
