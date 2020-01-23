/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
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
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        if(K == 0) {
            ans.add(target.val);
            return ans;
        }
        find(root, target, K);
        return ans;
    }

    int find(TreeNode node, TreeNode target, int k) {
        if(node == null) return -1;
        
        if(node.equals(target)){
            add(node, 0, k); 
            return 0;
        }
        int left = find(node.left, target, k);
        int right = find(node.right, target, k);
        if(left != -1) {
            left ++;
            if(left == k){
                ans.add(node.val);
            }else {
                add(node.right, left+1,k);
            }
            return left;
        }
        if(right != -1) {
            right ++;
            if(right == k){
                ans.add(node.val);
            }else {
                add(node.left, right+1,k);
            }
            return right;
        }
        return -1;//没找到。
    }

    void add(TreeNode node, int deep, int k) {
        if(node == null) return;
        if(deep == k) ans.add(node.val);
        else {
            add(node.left, deep+1, k);
            add(node.right, deep+1, k);
        }
    }
}

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
}
// @lc code=end

