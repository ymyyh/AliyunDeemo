package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode368 {
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Map<Integer, List<Integer>> recordMap = new HashMap<>();
        Arrays.sort(nums);;
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length; ++j){
                if(nums[j] % nums[i] == 0){
                    if(recordMap.containsKey(nums[i])){
                        recordMap.get(nums[i]).add(nums[j]);
                    }else{
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[j]);
                        recordMap.put(nums[i], tempList);
                    }
                }
            }
            map.put(nums[i], 0);
        }
        List<Integer> tempList = new ArrayList<>();
        for(int i = 0;i < nums.length; ++i){
            tempList.add(nums[i]);
            dfs(nums[i], 1, recordMap, tempList);
            tempList.remove(tempList.size() - 1);
        }

        return result;
    }

    public void dfs(int index, int count, Map<Integer, List<Integer>> recordMap, List<Integer> tempList){
        if(count <= map.get(index)){
            return;
        }else{
            map.put(index, count);
        }

        if(count > maxCount){
            maxCount = count;
            result = new ArrayList<>(tempList);
        }
        if(recordMap.containsKey(index)){
            for(int num : recordMap.get(index)){
                tempList.add(num);
                dfs(num, count + 1, recordMap, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
