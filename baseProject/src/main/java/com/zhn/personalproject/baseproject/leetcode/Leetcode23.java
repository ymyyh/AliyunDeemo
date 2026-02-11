package com.zhn.personalproject.baseproject.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode pointer = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode node : lists){
            if(null != node){
                pq.offer(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(null != node.next){
                pq.offer(node.next);
            }
            pointer.next = node;
            pointer = pointer.next;
        }

        return head.next;
    }
}
