package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> record = new ArrayList<>();
        List<Double> temp = new ArrayList<>();
        for(int i = 0;i <= query_row; ++i){
            if(i == 0){
                record.add((double) poured);
                continue;
            }
            for(int j = 0;j <= i; ++j){
                temp.add(0.0);
                if(j - 1 >= 0){
                    temp.set(j, temp.get(j) + Math.max(record.get(j - 1) - 1, 0) / 2.0);
                }
                if(j < record.size()){
                    temp.set(j, temp.get(j) + Math.max(record.get(j) - 1, 0) / 2.0);
                }
            }

            record = new ArrayList<>(temp);
            temp.clear();
        }
        return Math.min(1, record.get(query_glass - 1));
    }
}
