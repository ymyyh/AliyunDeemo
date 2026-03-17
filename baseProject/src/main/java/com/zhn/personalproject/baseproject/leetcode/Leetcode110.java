package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode110 {

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

    boolean tag = true;

    public boolean isBalanced(TreeNode root) {
        treeLength(root);
        return tag;
    }

    public int treeLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLength = treeLength(root.left);
        int rightLength = treeLength(root.right);
        if(Math.abs(leftLength - rightLength) > 1){
            tag = false;
        }
        return Math.max(leftLength, rightLength) + 1;
    }
}
