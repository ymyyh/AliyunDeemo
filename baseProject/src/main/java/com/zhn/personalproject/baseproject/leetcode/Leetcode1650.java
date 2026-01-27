package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode1650 {
    public int minCost(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> recordMap = new HashMap<>();
        for(int i = 0;i < n; ++i){
            recordMap.put(i, new HashMap<>());
        }
        for(int[] edge : edges){
            recordMap.get(edge[0]).put(edge[1], edge[2]);
        }
        for(int[] edge : edges){
            if(recordMap.get(edge[1]).containsKey(edge[0])){
                if(recordMap.get(edge[1]).get(edge[0]) > 2 * edge[2]){
                    recordMap.get(edge[1]).put(edge[0], 2 * edge[2]);
                }
            }else{
                recordMap.get(edge[1]).put(edge[0], 2 * edge[2]);
            }
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int point = node[0];
            int cost = node[1];
            for(int i : recordMap.get(node).keySet()){
                int newCost = cost + recordMap.get(point).get(i);
                result[i] = newCost;
                queue.offer(new int[]{i, newCost});

                if(i == n - 1){
                    return newCost;
                }
            }
        }
        return -1;
    }
}
