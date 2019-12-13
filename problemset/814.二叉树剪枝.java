/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 * AC 100%
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean rootOne = testHasOne(root);
        if(rootOne) return root;
        return null;
    }
    boolean testHasOne(TreeNode node){
        if(node == null) return false;
        boolean ans = false;
        if(node.val == 1) ans = true;
        boolean left = testHasOne(node.left);
        boolean right = testHasOne(node.right);
        if(!left) node.left = null;
        if(!right) node.right = null;
        return ans||left||right;
    }
}
// @lc code=end

