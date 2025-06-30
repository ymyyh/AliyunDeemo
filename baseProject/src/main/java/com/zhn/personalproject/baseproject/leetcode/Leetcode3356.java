package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3356 {

    int max = 0;
    int[] record;
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        int[][] arr1 = new int[n][n];
        int[][] arr2 = new int[m][m];


        for(int i = 0;i < n - 1; ++i){
            arr1[edges1[i][0]][edges1[i][1]] = 1;
            arr1[edges1[i][1]][edges1[i][0]] = 1;
        }

        for(int i = 0;i < m - 1; ++i){
            arr2[edges2[i][0]][edges2[i][1]] = 1;
            arr2[edges2[i][1]][edges2[i][0]] = 1;
        }

        int[][] dis1 = new int[n][n];
        int[][] dis2 = new int[m][m];

        int max2 = 0;
        for(int i = 0;i < m; ++i){
            max = 0;
            record = new int[m];
            dfs(dis2[i], arr2, i, 0, k - 1);
            max2 = Math.max(max, max2);
        }

        int[] result = new int[n];
        for(int i = 0;i < n; ++i){
            max = 0;
            record = new int[n];
            dfs(dis1[i], arr1, i, 0, k);
            result[i] = max + max2;
        }


        return result;
    }

    public void dfs(int[] dis, int[][] arr, int pos, int deep, int k){
        if(deep > k){
            return;
        }
        record[pos] = 1;
        dis[pos] = deep;
        max += 1;

        for(int i = 0;i < arr.length; ++i){
            if(arr[pos][i] == 1 && record[i] == 0){
                dfs(dis, arr, i, deep + 1, k);
            }
        }
    }
}
