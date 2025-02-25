package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1656 {
    int pointer = 0;
    String[] record;
    public Leetcode1656(int n) {
        record = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        record[idKey - 1] =  value;
        List<String> result = new ArrayList<>();
        while(null == record[pointer] && pointer < record.length){
            result.add(record[pointer]);
            pointer += 1;
        }
        return result;
    }
}
