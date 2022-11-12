package com.app.leetcode;

import com.app.Solution;
import com.sun.source.tree.Tree;

public class TreeMaximumSumPath implements Solution {

    int maxSumTillNow = 0;

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

    @Override
    public void execute() {

        TreeNode root = new TreeNode();
        int maxSum = getMaxSumPathSoln(root);
        System.out.println(maxSum);
    }

    private int getMaxSumPathSoln(TreeNode root) {

        if (root == null) {
            return 0;
        }

        maxSumTillNow = root.val;
        calculateMaxPathSumIncludingNode(root);
        return maxSumTillNow;
    }

    private int calculateMaxPathSumIncludingNode(TreeNode node) {

        if (node == null)
            return 0;

        int maxSumIncludingNode = node.val;
        int maxSumThroughNode;

        if (node.left == null && node.right == null) {
            maxSumIncludingNode = node.val;
            maxSumThroughNode = node.val;
        } else {
            int maxSumTillLeft = calculateMaxPathSumIncludingNode(node.left);
            int maxSumTillRight = calculateMaxPathSumIncludingNode(node.right);

            maxSumIncludingNode = Math.max(node.val,
                    Math.max(maxSumTillLeft + node.val, maxSumTillRight + node.val));
            maxSumThroughNode = maxSumTillLeft + node.val + maxSumTillRight;
        }
        maxSumTillNow = maxSumIncludingNode > maxSumTillNow ? maxSumIncludingNode : maxSumTillNow;
        maxSumTillNow = maxSumThroughNode > maxSumTillNow ? maxSumThroughNode : maxSumTillNow;

        return maxSumIncludingNode;
    }
}
