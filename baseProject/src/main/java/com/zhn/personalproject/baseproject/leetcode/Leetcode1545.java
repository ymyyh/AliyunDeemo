package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1545 {
    public char findKthBit(int n, int k){
        return find(n, k - 1);
    }
    public char find(int n, int k) {
        if(n == 1){
            return '0';
        }
        int mid = ((1 << n) - 1) / 2;
        if(k == mid){
            return '1';
        }else if(k < mid){
            return findKthBit(n - 1, k);
        }else{
            return (char) ('0' + ('1' - findKthBit(n - 1, 2 * mid - k)));
        }
    }

}
