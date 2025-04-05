package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1123 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode result = null;
    List<TreeNode> list = new ArrayList<>();
    List<TreeNode> recordList = new ArrayList<>();
    int maxDeep = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(0, root);

        dfs2(0, root);
        return result;
    }

    public void dfs(int deep, TreeNode node){
        if(node == null){
            return;
        }
        if(deep > maxDeep){
            maxDeep = deep;
            result = node;
        }
        dfs(deep + 1, node.left);
        dfs(deep + 1, node.right);
        return;
    }

    public void dfs2(int deep, TreeNode node) {
        if (node == null) {
            return;
        }
        if (deep == maxDeep) {
            if(recordList.size() == 0){
                result = node;
                recordList = new ArrayList<>(list);
            }else{
                int pointer = Math.min(recordList.size() - 1, list.size() - 1);
                while(pointer >= 0){
                    if(recordList.get(pointer) != list.get(pointer)){
                        pointer -= 1;
                        recordList.remove(recordList.size() - 1);
                    }else{
                        result = recordList.get(pointer);
                        break;
                    }
                }
            }
        }
        list.add(node);
        dfs2(deep + 1, node.left);
        dfs2(deep + 1, node.right);
        list.remove(list.size() - 1);
    }
}
