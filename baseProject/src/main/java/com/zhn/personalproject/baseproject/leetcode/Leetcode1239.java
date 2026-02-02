package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.List;

public class Leetcode1239 {
    int maxLength = 0;
    public int maxLength(List<String> arr) {
        int[] record = new int[26];
        Arrays.fill(record, 0);
        dfs(0, record, 0, arr);
        return maxLength;
    }

    public void dfs(int length, int[] record, int pos, List<String> arr){
        maxLength = Math.max(maxLength, length);
        if(pos >= arr.size()){
            return;
        }
        int[] temp = Arrays.copyOf(record, record.length);
        dfs(length, record, pos + 1, arr);
        record = temp;
        for(int i = 0;i < arr.get(pos).length(); ++i){
            if(record[arr.get(pos).charAt(i) - 'a'] > 0){
                return;
            }else{
                record[arr.get(pos).charAt(i) - 'a']++;
                length++;
            }
        }
        dfs(length, record, pos + 1, arr);
    }

}
