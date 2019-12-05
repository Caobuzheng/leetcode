/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
import java.util.*;
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        List<TreeNode> level = new LinkedList<>();
        level.add(root);

        while(!level.isEmpty()) {
            List<TreeNode> nextLevel = new LinkedList<>();
            int min = Integer.MIN_VALUE;
            for(TreeNode node: level) {
                min = Math.max(min, node.val);
                if(node.left != null) {
                    nextLevel.add(node.left);
                }
                if(node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            ans.add(min);
            level = nextLevel;
        }
        return ans;
    }
}

// @lc code=end

