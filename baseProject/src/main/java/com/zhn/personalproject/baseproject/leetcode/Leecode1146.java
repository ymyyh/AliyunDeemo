package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leecode1146 {
    int version = 0;
    ArrayList<ArrayList<ArrayList<Integer>>> numArr = new ArrayList<>();
    public Leecode1146(int length) {
        for(int i = 0;i < length; ++i){
            ArrayList<ArrayList<Integer>> tempArr1 = new ArrayList<>();
            ArrayList<Integer> tempArr2 = new ArrayList<>();
            tempArr2.add(0);
            tempArr2.add(0);

            tempArr1.add(tempArr2);
            numArr.add(tempArr1);
        }
    }

    public void set(int index, int val) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        if(numArr.get(index).get(numArr.get(index).size() - 1).get(0) == version){
            numArr.get(index).remove(numArr.get(index).size() - 1);
        }
        tempArr.add(version);
        tempArr.add(val);
        numArr.get(index).add(tempArr);
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        int start = 0;
        int end = numArr.get(index).size() - 1;
        int mid = (start + end) / 2;
        while(end - start > 1){
            mid = (start + end) / 2;
            int currentVersion = numArr.get(index).get(mid).get(0);
            if(currentVersion == snap_id){
                return numArr.get(index).get(mid).get(1);
            }
            else if(currentVersion < snap_id){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(snap_id == numArr.get(index).get(end).get(0)){
            return numArr.get(index).get(end).get(1);
        }
        return numArr.get(index).get(start).get(1);
    }
}






