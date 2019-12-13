/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        if(root == null) return 0;
        help(root, root.val, root.val);
        return ans;
    }
    void help(TreeNode node, int max, int min) {
        if(node == null) return;
        ans = Math.max(ans,Math.max(Math.abs(max - node.val), Math.abs(min - node.val)));
        if(node.val > max) {
            max = node.val;
        }
        if(node.val < min) {
            min = node.val;
        }
        help(node.left, max, min);
        help(node.right, max, min);
    }
}
// @lc code=end

