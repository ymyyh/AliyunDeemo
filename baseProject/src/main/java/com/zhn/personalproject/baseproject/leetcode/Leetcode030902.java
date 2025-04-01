package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode030902 {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[][] record = new int[nums1.length][2];
        for(int i = 0;i < nums1.length;i++){
            record[i][0] = nums1[i];
            record[i][1] = nums2[i];
        }
        Arrays.sort(record, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Map<Integer, Long> recordMap = new HashMap<>();
        long max = 0;
        for(int i = 0;i < record.length;i++){
            if(i == 0 || record[i][0] != record[i - 1][0]){
                recordMap.put(record[i][0], max);
            }
            if(pq.size() < k && record[i][1] > 0){
                pq.offer(record[i][1]);
                max += record[i][1];
            }else if(pq.size() >= k && record[i][1] > 0 && record[i][1] > pq.peek()){
                int polled = pq.poll();
                pq.offer(record[i][1]);
                max = max - polled + record[i][1];
            }
        }
        long[] result = new long[nums1.length];
        for(int i = 0;i < nums1.length;i++){
            result[i] = recordMap.get(nums1[i]);
        }

        return result;
    }
}
