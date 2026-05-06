package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode188 {
    public int getMinDistance(int[] nums, int target, int start) {
        int dis = 0;
        while(start + dis < nums.length || start - dis >= 0){
            if(start + dis < nums.length && nums[start + dis] == target){
                return dis;
            }else if(start - dis >= 0 && nums[start - dis] == target){
                return dis;
            }
            dis += 1;
        }
        return -1;
    }
}
