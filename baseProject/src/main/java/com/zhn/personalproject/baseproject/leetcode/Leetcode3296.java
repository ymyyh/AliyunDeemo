package com.zhn.personalproject.baseproject.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode3296 {
    class Node{
        int workerNum;
        int time;
        long sum;
        public Node(int workerNum, int time, long sum){
            this.workerNum = workerNum;
            this.time = time;
            this.sum = sum;
        }
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (o1.sum - o2.sum) > 0 ? 1 : -1;
            }
        });

        long result = 0;
        for(int i = 0;i < workerTimes.length; ++i){
            pq.offer(new Node(i, 1, workerTimes[i]));
        }
        for(int i = 0;i < mountainHeight; ++i){
            Node temp = pq.poll();
            result = Math.max(result, temp.sum);
            pq.offer(new Node(temp.workerNum, temp.time + 1, temp.sum + ((long) workerTimes[temp.workerNum]) * ((long) (temp.time + 1))));
        }

        return result;
    }
}
