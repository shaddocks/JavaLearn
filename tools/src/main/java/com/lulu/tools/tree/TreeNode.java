package com.lulu.tools.tree;

import lombok.NoArgsConstructor;

/**
 * 树节点
 */
@SuppressWarnings("unused")
@NoArgsConstructor
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
