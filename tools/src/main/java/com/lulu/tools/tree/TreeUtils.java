package com.lulu.tools.tree;

public class TreeUtils {
    public static TreeNode buildTree(String[] nums, int index) {
        if (index >= nums.length || nums[index].equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(nums[index]));
        node.left = buildTree(nums, 2 * index + 1);
        node.right = buildTree(nums, 2 * index + 2);
        return node;
    }
}
