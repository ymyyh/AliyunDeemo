package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode pre = new ListNode();
        result.next = head;
        pre = result;
        ListNode[] arr = new ListNode[k];
        ListNode pointer = head;
        int count = 0;
        while(null != pointer){
            while(null != pointer && count < k){
                arr[count] = pointer;
                pointer = pointer.next;
                count += 1;
            }

            if(count == k){
                for(int i = k - 1;i >= 0; --i){
                    pre.next = arr[i];
                    pre = pre.next;
                }
            }
        }
        return result;
    }
}
