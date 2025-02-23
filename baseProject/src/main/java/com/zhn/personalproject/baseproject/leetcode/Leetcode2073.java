package com.zhn.personalproject.baseproject.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < tickets.length; ++i){
            queue.offer(i);
        }
        int time = 0;
        int tempPos = 0;
        while(!queue.isEmpty()){
            tempPos = queue.poll();
            tickets[tempPos] -= 1;
            time += 1;
            if(tempPos == k && tickets[tempPos] == 0){
                return time;
            }
            if(tickets[tempPos] != 0) {
                queue.offer(tempPos);
            }
        }
        return time;
    }
}
