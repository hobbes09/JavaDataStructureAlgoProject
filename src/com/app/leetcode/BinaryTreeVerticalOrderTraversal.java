package com.app.leetcode;

import com.app.Solution;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal implements Solution {

    HashMap<Integer, ArrayList<TreeNode>> verticalTraversalResult = new HashMap<>();
    Deque<TreeNodeWithLevel> queue = new LinkedList<>();

    @Override
    public void execute() {

        TreeNode l2left = new TreeNode(15);
        TreeNode l2right = new TreeNode(7);
        TreeNode l1right = new TreeNode(20, l2left, l2right);
        TreeNode l1left = new TreeNode(9);
        TreeNode root = new TreeNode(3, l1left, l1right);

        verticalTraversal(root);

    }

    public void verticalTraversal(TreeNode root) {

        queue.offer(new TreeNodeWithLevel(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeWithLevel treeNodeWithLevel = queue.poll();
            TreeNode nodeToExplore = treeNodeWithLevel.getTreeNode();
            int nodeToExploreLevel = treeNodeWithLevel.getLevel();
            addNodeToVerticalTraversalResult(nodeToExplore, nodeToExploreLevel);
            if (nodeToExplore.left != null) {
                queue.offer(new TreeNodeWithLevel(nodeToExplore.left, nodeToExploreLevel+1));
            }
            if (nodeToExplore.right != null) {
                queue.offer(new TreeNodeWithLevel(nodeToExplore.right, nodeToExploreLevel+1));
            }
        }

        printAccumulatedLevelOrderTraversal(verticalTraversalResult);
    }

    private void printAccumulatedLevelOrderTraversal(HashMap<Integer, ArrayList<TreeNode>> verticalTraversalResult) {
        Set<Integer> keys = verticalTraversalResult.keySet();
        int maxSize = keys.size();
        for (int i = 0; i < maxSize; i++) {
            // Print code here
        }
    }


    private void addNodeToVerticalTraversalResult(TreeNode node, int level) {

        ArrayList<TreeNode> existingNodeListOfLevel = verticalTraversalResult.get(level);
        if (existingNodeListOfLevel == null) {
            existingNodeListOfLevel = new ArrayList<>();
        }
        existingNodeListOfLevel.add(node);
        verticalTraversalResult.put(level, existingNodeListOfLevel);
    }

    public class TreeNodeWithLevel {
        TreeNode treeNode;
        int level;

        public TreeNodeWithLevel(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public int getLevel() {
            return level;
        }
    }

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
}
