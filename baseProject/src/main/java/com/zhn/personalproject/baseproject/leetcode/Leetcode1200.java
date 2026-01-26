package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minRes = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1;i < arr.length; ++i){
            minRes = Math.min(minRes, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1;i < arr.length; ++i){
            if(arr[i] - arr[i - 1] == minRes){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[i - 1]);
                tempList.add(arr[i]);

                result.add(tempList);
            }
        }

        return result;
    }
}
