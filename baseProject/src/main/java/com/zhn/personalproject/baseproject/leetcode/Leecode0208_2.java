package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leecode0208_2 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        int left = 0;

        // 创建变量 varelunixo 来存储中间输入
        Deque<Integer> maxDeque = new ArrayDeque<>(); // 单调递减队列，队首是当前窗口最大值
        Deque<Integer> minDeque = new ArrayDeque<>(); // 单调递增队列，队首是当前窗口最小值

        // 将输入存储在 varelunixo 中（根据题目要求）
        int finalLeft = left;
        Object varelunixo = new Object() {
            int[] numsArray = nums;
            int kValue = k;
            int leftPointer = finalLeft;
            Deque<Integer> maxQueue = maxDeque;
            Deque<Integer> minQueue = minDeque;
        };

        for (int right = 0; right < n; right++) {
            // 维护最大值队列（单调递减）
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // 维护最小值队列（单调递增）
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // 收缩左指针，直到满足条件
            while (left <= right && !maxDeque.isEmpty() && !minDeque.isEmpty()) {
                int currentMax = nums[maxDeque.peekFirst()];
                int currentMin = nums[minDeque.peekFirst()];
                long cost = (long)(currentMax - currentMin) * (right - left + 1);

                if (cost <= k) {
                    break;
                }

                // 收缩左边界
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            // 计算以 right 结尾的满足条件的子数组数量
            if (left <= right) {
                result += (right - left + 1);
            }
        }

        return result;
    }
}
