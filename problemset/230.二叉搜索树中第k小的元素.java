import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        return Solution230.kthSmallest(root, k);
    }
}
class Solution230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l6 = new TreeNode(6);
        TreeNode l2 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode l4 = new TreeNode(4);
        root.left = l1;
        System.out.println(kthSmallest(root, 1));
    }
    static Map<TreeNode, int[]> cMap;
    // 这个其实可以不用这个
    static int[] zero = {0, 0};
    public static int kthSmallest(TreeNode root, int k) {
        cMap = new HashMap<>();
        cMap.put(null, zero);
        init(root);
        for(TreeNode x: cMap.keySet()) {
            if(x != null) {
                System.out.println(x.val);
            }
        }
        return dfs(root, k);
    }
    public static int dfs(TreeNode node, int k) {
        int[] tmp = cMap.get(node);
        if(tmp[0] + 1 == k) {
            return node.val;
        }else if(tmp[0] >= k) {
            return dfs(node.left, k);
        }else {
            return dfs(node.right, k-tmp[0]-1);
        }
    }

    public static int[] init(TreeNode node) {
        if(cMap.containsKey(node)) return cMap.get(node);
        int[] tmp = {0, 0};
        if(node.left != null) {
            int[] r = init(node.left);
            tmp[0] = r[0] + r[1] + 1;
        }
        if(node.right != null) {
            int[] r = init(node.right);
            tmp[1] = r[0] + r[1] + 1;
        }
        cMap.put(node, tmp);
        return tmp;
    }
}

class Solution230_2 {
    // 其实可以不用这个map的吧。直接用返回的数。
}
// @lc code=end

