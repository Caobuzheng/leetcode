import java.util.*;

/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */

// @lc code=start
class Solution {
    public static List<Integer> pathInZigZagTree(int label) {
        return So1104.pathInZigZagTree(label);
    }
}

class So1104 {
    public static void main(String[] args) {
        // pathInZigZagTree(26);
        // pathInZigZagTree(14);
        pathInZigZagTree(1);
    }
    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        int[][] lrTree = new int[31][2]; 
        int[] root = {1, 1};
        lrTree[0] = root;
        // 初始化。
        for(int i = 1; i<31; i++) {
            int l = lrTree[i-1][0];
            int r = lrTree[i-1][1];
            if(l>r) {
                l = l+1;
                r = l*2 - 1;
            }else {
                r = r+1;
                l = r*2 - 1;
            }
            int[] next = {l, r};
            lrTree[i] = next;
        }
        int level = 0;
        while(level<31) {
            int a = (lrTree[level][0] - label) ;
            int b = lrTree[level][1] - label;
            if((a<=0 && b>= 0) || (a>=0 && b<=0)) {
                break;
            }
            level++;
        }
        ans.add(label);
        while(level > 0) {
            int index = Math.abs(lrTree[level][0] - label);
            int nextIndex = (index / 2) * (level%2 == 0? -1:1);
            label = lrTree[level-1][0] + nextIndex;
            ans.add(label);
            level--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end

