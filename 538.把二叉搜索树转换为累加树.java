/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (57.11%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 17.4K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 例如：
 * 
 * 
 * 输入: 二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
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
    public TreeNode convertBST(TreeNode root) {
        return ConvertBST.convertBST(root);
    }
}
class ConvertBST {
    public static void main(String[] args) {
    }
    public static TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    public static void helper(TreeNode node, int more) {
        if(node == null) return;
        // ok.
        node.val += more;
        if(node.right != null) {
            helper(node.right, more);
            node.val += node.right.val - more;
        }
        if(node.left != null) {
            helper(node.left, node.val);
        }
    }
}
// @lc code=end

