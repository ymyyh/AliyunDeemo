package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode3396 {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : new HashSet<Integer>(map.keySet())){
            if(map.get(key) == 1){
                map.remove(key);
            }
        }
        int n = 0;
        int count = 0;
        int pointer = 0;
        while(pointer < nums.length && !map.isEmpty()){
            n = 0;
            while(n < 3 && pointer < nums.length){
                if(map.containsKey(nums[pointer])){
                    if(map.get(nums[pointer]) == 1){
                        map.remove(nums[pointer]);
                    }else{
                        map.put(nums[pointer], map.get(nums[pointer]) - 1);
                    }
                }
                 n += 1;
            }
            count += 1;
        }
        return count;
    }
}
