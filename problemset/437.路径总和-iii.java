/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int sum) {
        return Solution437.pathSum(root, sum);
    }
}

class Solution437 {
    static int count = 0;
    public static int pathSum(TreeNode root, int sum) {
        count = 0;
        help(root, sum, 0, 0);
        return count;
    }

    public static void help(TreeNode node, int sum, int remain,int indexs) {
        if(node==null) return;
        int tmp = remain + node.val;
        if(tmp == sum) {
            count++;
        }
        help(node.left, sum, tmp, indexs+1);
        help(node.right, sum, tmp, indexs+1);
        if(indexs==0){
            help(node.left, sum, 0, 0);
            help(node.right, sum, 0, 0);
        }
    }
    // [-8,6,8,null,null,8,2,null,null,null,-2]\n-2
// -2
}
// @lc code=end

