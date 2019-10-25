import java.util.HashMap;
import java.util.Map;

/*
 *  AC
 *  
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深结点的最小子树
 *
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 *
 * algorithms
 * Medium (45.91%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    1.3K
 * Total Submissions: 2.7K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]'
 *
 * 怎么理解，就是找到最深的节点。
 * 然后返回所有最深节点的。这个怎么搞的来？
 * if 右大于左面。 
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // mark first.
        if(root == null) return root;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        initTreeMap(root, map);
        TreeNode node = root;
        while(node != null) {
            if(node.left == null && node.right ==null) return node;
            int left = map.getOrDefault(node.left, 0);
            int right = map.getOrDefault(node.right, 0);
            if(left == right) return node;
            if(left > right) {
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return node;

    }
    private void initTreeMap (TreeNode node, Map<TreeNode, Integer> map) {
        if(node == null || map.containsKey(node)) return;
        if(node.left == null && node.right ==null) {
            map.put(node, 1);
            return;
        }
        initTreeMap(node.left, map);
        initTreeMap(node.right, map);
        // 
        int left = map.getOrDefault(node.left, 0);
        int right = map.getOrDefault(node.right, 0);
        map.put(node, Math.max(left, right) +1);
    }
}
// mark frist

// @lc code=end

