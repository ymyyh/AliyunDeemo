package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] record1 = new int[edges.length];
        int[] record2 = new int[edges.length];

        Arrays.fill(record1, -1);
        Arrays.fill(record2, -1);
        record1[node1] = 0;
        record2[node2] = 0;

        int deep = 0;
        int pos = node1;
        while(true){
            deep += 1;
            if(edges[pos] != -1 && edges[pos] != node1 && record1[edges[pos]] == -1){
                record1[edges[pos]] = deep;
                pos = edges[pos];
            }else{
                break;
            }
        }
        deep = 0;
        pos = node2;
        while(true){
            deep += 1;
            if(edges[pos] != -1 && edges[pos] != node2 && record2[edges[pos]] == -1){
                record2[edges[pos]] = deep;
                pos = edges[pos];
            }else{
                break;
            }
        }

        int result = Integer.MAX_VALUE;
        int node = -1;
        for(int i = 0;i < edges.length; ++i){
            if(-1 == record1[i] || -1 == record2[i]){
                continue;
            }
            if(Math.max(record1[i], record2[i]) < result){
                result = Math.max(record1[i], record2[i]);
                node = i;
            }
        }
        return node;

    }
}


















