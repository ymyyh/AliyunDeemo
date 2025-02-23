package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2860 {
    public int countWays(List<Integer> nums) {
        int count = 0;
        Collections.sort(nums);
        for(int i = -1;i < nums.size(); ++i){
            if(i == -1){
                if(nums.get(0) > 0) {
                    count += 1;
                }
            }
            else if(i == nums.size() - 1){
                if(nums.get(nums.size() - 1) < nums.size()) {
                    count += 1;
                }
            }
            else if(nums.get(i) < (i + 1) && nums.get(i + 1) > (i + 1)){
                count += 1;
            }
        }
        return count;
    }
}
