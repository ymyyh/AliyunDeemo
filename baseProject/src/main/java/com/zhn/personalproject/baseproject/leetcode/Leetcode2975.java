package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode2975 {
    long res = (long) 1e9 + 7;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> lengthSet1 = new HashSet<>();
        lengthSet1.add(m - 1);
        for(int i = 0;i < hFences.length; ++i){
            for(int j = i + 1;j < hFences.length; ++j) {
                lengthSet1.add(Math.abs(hFences[i] - hFences[j]));
            }
            lengthSet1.add(Math.abs(hFences[i] - 1));
            lengthSet1.add(Math.abs(m - hFences[i]));
        }

        Set<Integer> lengthSet2 = new HashSet<>();
        lengthSet2.add(n - 1);
        for(int i = 0;i < vFences.length; ++i){
            for(int j = i + 1;j < vFences.length; ++j) {
                lengthSet2.add(Math.abs(vFences[i] - vFences[j]));
            }
            lengthSet2.add(Math.abs(vFences[i] - 1));
            lengthSet2.add(Math.abs(n - vFences[i]));
        }

        List<Integer> lengthList1 = new ArrayList<>(lengthSet1);
        Collections.sort(lengthList1);
        for(int i = lengthList1.size() - 1;i >= 0; --i){
            if(lengthSet2.contains(lengthList1.get(i))){
                return (int) (((long) lengthList1.get(i) % res) * ((long) lengthList1.get(i) % res) % res);
            }
        }
        return -1;
    }
}
