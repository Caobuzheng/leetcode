/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode ans = root;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean tag = true;
            for(int i= 0; i< size;i++) {
                TreeNode node = queue.poll();
                if(tag) {
                    ans = node;
                    tag = false;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return ans.val;
    }
}
// @lc code=end

