package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3761 {
    public int minMirrorPairDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> recordMap = new HashMap<>();
        Map<Integer, Integer> mirrorMap = new HashMap<>();
        for(int i = nums.length - 1;i >= 0; --i){
            if(!mirrorMap.containsKey(nums[i])){
                mirrorMap.put(nums[i], getMirror((nums[i])));
            }
            int mirrorInt = mirrorMap.get(nums[i]);
            if(recordMap.containsKey(mirrorInt)){
                result = Math.min(result, recordMap.get(mirrorInt) - i);
            }
            recordMap.put(nums[i], i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int getMirror(int input){
        int output = 0;
        while(input != 0){
            output = output * 10 + (input % 10);
            input /= 10;
        }
        return output;
    }
}
