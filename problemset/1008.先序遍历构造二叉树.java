/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 先序遍历构造二叉树
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, 0, preorder.length-1);
    }

    public TreeNode help(int[] preorder, int l, int r) {
        if(l>r || r>= preorder.length || l<0) return null;
        int val = preorder[l];
        TreeNode node = new TreeNode(val);
        int i = l+1;
        boolean tag = false;
        for(;i<=r;i++) {
            if(preorder[i]>=val) break;
            tag = true;
        }
        if(tag) {
            node.left = help(preorder, l+1, i-1);
        }
        node.right = help(preorder, i, r);
        return node;
    }
}
// @lc code=end

