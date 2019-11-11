import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
    public int sumRootToLeaf(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode tmp = root;
        while(!list.isEmpty()){
            tmp = list.pollFirst();
            if(tmp.left == null && tmp.right == null){
                res += tmp.val;
            }
            int c = tmp.val*2;
            if(tmp.left != null) {
                tmp.left.val = c+ tmp.left.val;
                list.addLast(tmp.left);
            }
            if(tmp.right != null) {
                tmp.right.val = c + tmp.right.val;
                list.addLast(tmp.right);
            }
        }
        return res;
    }
}
// @lc code=end

