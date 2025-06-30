package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3372 {
    int max = 0;
    int[] record;
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        Map<Integer, List<Integer>> record1 = new HashMap<>();
        Map<Integer, List<Integer>> record2 = new HashMap<>();

        for(int i = 0;i < n - 1; ++i){
            if(record1.containsKey(edges1[i][0])){
                record1.get(edges1[i][0]).add(edges1[i][1]);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(edges1[i][1]);
                record1.put(edges1[i][0], temp);
            }
        }

        for(int i = 0;i < m - 1; ++i){
            if(record2.containsKey(edges2[i][0])){
                record2.get(edges2[i][0]).add(edges2[i][1]);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(edges2[i][1]);
                record2.put(edges2[i][0], temp);
            }
        }

        int[][] dis1 = new int[n][n];
        int[][] dis2 = new int[m][m];

        int max2 = 0;
        for(int i = 0;i < m; ++i){
            max = 0;
            record = new int[m];
            dfs(dis2[i], record2, i, 0, k - 1);
            max2 = Math.max(max, max2);
        }

        int[] result = new int[n];
        for(int i = 0;i < n; ++i){
            max = 0;
            record = new int[n];
            dfs(dis1[i], record1, i, 0, k);
            result[i] = max + max2;
        }


        return result;
    }

    public void dfs(int[] dis, Map<Integer, List<Integer>> map, int pos, int deep, int k){
        record[pos] = 1;
        dis[pos] = deep;
        max += 1;

        if(deep > k - 1){
            return;
        }

        for(int i = 0;i < map.get(pos).size(); ++i){
            if(map.get(pos).get(i) == 1 && record[map.get(pos).get(i)] == 0){
                dfs(dis, map, i, deep + 1, k);
            }
        }
    }
}
