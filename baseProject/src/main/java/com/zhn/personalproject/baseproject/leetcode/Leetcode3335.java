package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode3335 {
    int res = (int) (1e9 + 7);
    public int lengthAfterTransformations(String s, int t) {
        List<Integer> record = new ArrayList<>();
        for(int i = 0;i < 26; ++i){
            record.add(0);
        }
        for(int i = 0;i < s.length(); ++i){
            int pos = 25 - (s.charAt(i) - 'a');
            record.set(pos, record.get(pos) + 1);
        }

        for(int i = 0;i < t; ++i){
            int pos = record.size() - 1;
            record.set(pos, (record.get(pos) + record.get(i)) % res);
            record.add(record.get(i) % res);
        }
        int result = 0;
        for(int i = t;i < t + 26; ++i){
            result = (result + record.get(i)) % res;
        }

        return result;
    }
}
