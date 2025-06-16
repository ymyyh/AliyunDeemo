package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2094 {
    List<Integer> list = new ArrayList<>();
    public int[] findEvenNumbers(int[] digits) {
        int[] record = new int[10];
        for(int num : digits){
            record[num] += 1;
        }
        dfs(0, record, 0);
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size(); ++i){
            result[i] = list.get(i);
        }
        return result;
    }

    public void dfs(int count, int[] record, int num){
        if(count == 3){
            list.add(num);
            return;
        }
        for(int i = 0;i < 10; ++i){
            if((count == 0 && i == 0) || (count == 2 && i % 2 == 1) || (record[i] <= 0)){
                continue;
            }
            record[i] -= 1;
            dfs(count + 1, record, num * 10 + i);
            record[i] += 1;
        }
    }
}
