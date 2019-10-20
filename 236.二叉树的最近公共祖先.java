import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出: 3
    解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
    示例 2:

    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出: 5
    解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // how to?
        // 这个用个啥么遍历方式，然后是不是就有解了？
        
        return null;
    }

    // 那个方法太奇葩了的。
    private List<TreeNode> getTreeList(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(true) {
            TreeNode tmp = stack.peek();
            if(root.left != null) {
                // 深度遍历的呗。找到x的呗。这个我怎么说，我应该练习下我深度遍历的技术的呗。
                // 草泥马的，老子不会
            }
        }
    }
}
// @lc code=end

