package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3719 {
    public int longestBalanced(int[] nums) {
        int result = 0;
        Set<Integer> recordSet1 = new HashSet<>();
        Set<Integer> recordSet2 = new HashSet<>();
        for(int i = 0;i < nums.length; ++i){
            recordSet1.clear();
            recordSet2.clear();
            for(int j = i;j >= 0; --j){
                if(nums[j] % 2 == 1){
                    recordSet1.add(nums[j]);
                }else{
                    recordSet2.add(nums[j]);
                }

                if(recordSet1.size() == recordSet2.size()){
                    result = Math.max(result, i - j + 1);
                }
            }
        }
        return result;
    }
}
