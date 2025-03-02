package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode100540 {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i]; // 前缀和
        }

        int[] f = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                d[j] = f[j] - s[j];
            }
            // f[j] 置为 -inf，因为即使 [0,j) 全选，也没有 i 个长为 m 的子数组
            Arrays.fill(f, i * m - m, i * m, Integer.MIN_VALUE / 2);
            int mx = Integer.MIN_VALUE;
            // 左右两边留出足够空间
            for (int j = i * m; j <= n - (k - i) * m; j++) {
                // mx 表示最大的 f[L]-s[L]，其中 L 在区间 [(i-1)*m, j-m] 中
                mx = Math.max(mx, d[j - m]);
                f[j] = Math.max(f[j - 1], mx + s[j]); // 不选 vs 选
            }
        }
        return f[n];
    }

}
