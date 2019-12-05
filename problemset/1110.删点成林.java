import java.util.*;

/*
 * @lc app=leetcode.cn id=1110 lang=java
 *
 * [1110] 删点成林
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
class TreeNode {
         int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { val = x; }
}
class Solution {
    /**
     * 树中的节点数最大为 1000。
        每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
        to_delete.length <= 1000
        to_delete 包含一些从 1 到 1000、各不相同的值。
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root == null || to_delete.length == 0) return list;
        list.add(root);

        for(int delete: to_delete) {
            // 也可能是。
            boolean find = false;
            // 也可能是删根的呀。
            while(!find) {
                for(TreeNode iroot: list) {
                    Queue<TreeNode> queue = new LinkedList<>();
                }
            }
        }
        return list;
    }
}
// @lc code=end

