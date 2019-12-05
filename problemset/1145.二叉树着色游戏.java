import java.util.*;
/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
 */

import javax.swing.tree.TreeNode;

// @lc code=start
class Solution {

    int left = 0;
    int right = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        left = 0;
        right = 0;
        int total = getCount(root, x);
        int res = total - left - right -1;
        return res > total/2 || left > total/2 || right > total /2;
    }

    public int getCount(TreeNode node, int x) {
        if(node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i< size; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                if(tmp.val == x) {
                    left = getCount(tmp.left , x);
                    right = getCount(tmp.right, x);
                }
                count++;
            }
        }
        return count;
    } 
}
// @lc code=end

