package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode21 {

        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode pointer1 = list1;
            ListNode pointer2 = list2;

            ListNode head = new ListNode();
            ListNode pointerAll = head;

            while(null != pointer1 || null != pointer2){
                if(null == pointer1){
                    pointerAll.next = pointer2;
                    pointer2 = pointer2.next;
                    pointerAll = pointerAll.next;
                    continue;
                }
                if(null == pointer2){
                    pointerAll.next = pointer1;
                    pointer1 = pointer1.next;
                    pointerAll = pointerAll.next;
                    continue;
                }
                if(pointer1.val < pointer2.val){
                    pointerAll.next = pointer1;
                    pointer1 = pointer1.next;
                    pointerAll = pointerAll.next;
                }else{
                    pointerAll.next = pointer2;
                    pointer2 = pointer2.next;
                    pointerAll = pointerAll.next;
                }
            }
            return head.next;
        }
}
