/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的满二叉树
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
    public List<TreeNode> allPossibleFBT(int N) {
        return Solution894.allPossibleFBT(N);
    }
}

class Solution894 {
    public static List<TreeNode> allPossibleFBT(int N) {
        List<List<TreeNode>> dp = new LinkedList<>();
        if(N%2 == 0) {
            return new ArrayList<>();
        }else {
            List<TreeNode> levelOne = new LinkedList<>();
            levelOne.add(new TreeNode(0));
            dp.add(levelOne);
            for(int i = 3; i<=N;i+=2) {
                List<TreeNode> level = new LinkedList<>();
                for(int j = 1;j<i;j+=2) {
                    List<TreeNode> lefts = dp.get(j/2);
                    List<TreeNode> rights = dp.get((i-1-j)/2);
                    for(TreeNode left: lefts) {
                        for(TreeNode right: rights) {
                            TreeNode tmpRoot = new TreeNode(0);
                            tmpRoot.left = left;
                            tmpRoot.right = right;
                            level.add(tmpRoot);
                        }
                    }
                }
                dp.add(level);
            }
        }
        return dp.get(N/2);
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

// @lc code=end
