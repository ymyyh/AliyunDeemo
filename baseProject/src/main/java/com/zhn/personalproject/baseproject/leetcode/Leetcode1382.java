package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode1382 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> rootList = new ArrayList<>();
        dfs(root, rootList);
        Collections.sort(rootList, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        return buildTree(0, rootList.size() - 1, rootList);
    }
    public TreeNode buildTree(int left, int right, List<TreeNode> rootList){
        if(right < left){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = rootList.get(mid);
        node.left = buildTree(left, mid - 1, rootList);
        node.right = buildTree(mid + 1, right, rootList);

        return node;
    }
    public void dfs(TreeNode node, List<TreeNode> rootList){
        if(null == node){
            return;
        }
        rootList.add(node);
        dfs(node.left, rootList);
        dfs(node.right, rootList);
    }
}
