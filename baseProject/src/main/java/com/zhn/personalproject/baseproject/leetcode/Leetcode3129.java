package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3129 {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long res = 1000000007;
        int length = zero + one;
        long[][] dp0 = new long[zero + one + 1][zero + 1];
        long[][] dp1 = new long[zero + one + 1][one + 1];

        dp0[0][0] = 1;
        dp1[0][0] = 1;

        for(int i = 1;i <= length; ++i){
            int maxZero = Math.min(zero, limit);
            int maxOne = Math.min(one, limit);

            for(int j = 1;j <= maxOne; ++j){
                for(int k = 1;k <= Math.min(i, j); ++k){
                    dp1[i][j] = (dp1[i][j] + dp0[i - k][j - k]) % res;
                }
            }

            for(int j = 1;j <= maxZero; ++j){
                for(int k = 1;k <= Math.min(i, j); ++k){
                    dp0[i][j] = (dp0[i][j] + dp1[i - k][j - k] % res);
                }
            }
            if(i <= maxOne) {
                dp1[i][0] = dp0[i][i];
            }
            if(i <= maxZero) {
                dp0[i][0] = dp1[i][i];
            }
        }
        long sum = 0;
        for(int i = 0;i <= zero; ++i){
            sum = (sum + dp0[zero + one][i]) % res;
        }
        for(int i = 0;i <= one; ++i){
            sum = (sum + dp1[zero + one][i]) % res;
        }

        return (int) (sum % res);
    }
}
