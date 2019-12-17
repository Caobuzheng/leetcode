import java.util.Map;

/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// 1,null,1,1,1,1,1,1
// [1,null,1,1,1,1,1,1]
import java.util.*;

class Solution {
    public int longestUnivaluePath(TreeNode root) {
        return Solution687_v2.longestUnivaluePath(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution687_v2{
    public static void main(String[] args) {
        System.out.println("yo");
    }
    public static int longestUnivaluePath(TreeNode root) {
        // 写的干净点吧。
        if(root != null) {
            // 都是返回以root 为定点的。
            int rootVal = MaxLength(root.left, root.val) + MaxLength(root.right, root.val);
            return Math.max(Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)), rootVal);
        }else {
            return 0;
        }
    }
    static int MaxLength(TreeNode node, int val) {
        if(node == null) return 0;
        if(node.val != val) return 0;
        return Math.max(MaxLength(node.left, val), MaxLength(node.right, val))+1;
    }
    
}

class Solution687 {
    static int ans = 0;
    static Map<TreeNode, Integer> map = new HashMap<>();

    public static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        map = new HashMap<>();
        if (root == null)
            return ans;
        init(root);
        dfs(root);
        return ans - 1;
    }

    static void dfs(TreeNode node) {
        if (node == null)
            return;
        int max = 1;
        // System.out.println(map.get(node));
        if (node.left == null || node.right == null) {
            max = map.get(node);
        } else {
            max = 1;
            if (node.left.val == node.val)
                max += map.get(node.left);
            if (node.right.val == node.val)
                max += map.get(node.right);
        }
        ans = Math.max(ans, max);
        dfs(node.left);
        dfs(node.right);
    }

    static int init(TreeNode node) {
        if (node == null)
            return 0;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int max = 1;
        if (node.left != null) {
            if (node.val == node.left.val) {
                max = Math.max(init(node.left) + 1, max);
            } else {
                init(node.left);
            }
        }
        // 可以减少Dfs那步的。
        if (node.right != null) {
            if (node.val == node.right.val) {
                max = Math.max(init(node.right) + 1, max);
            } else {
                init(node.right);
            }
        }
        map.put(node, max);
        return max;
    }
}
// @lc code=end
