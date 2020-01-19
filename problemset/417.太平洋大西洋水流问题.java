/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

 import java.util.*;
// @lc code=start
class Solution {
    int[][] dp;
    int[][] gos = {{0,1},{0,-1},{-1,0},{1,0}};
    int m = -1;
    int n = -1;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        m = matrix.length;
        if(m == 0) return res;
        n = matrix[0].length;
        if(n == 0) return res;
        dp = new int[m][n];

        for(int i = 0;i<m;i++) {
            dp[i][0] = 1;
            dp[i][n-1] = 2;
        }
        for(int i =0;i<n;i++) {
            dp[0][i] = 1;
            dp[m-1][i] = 2;
        }

        // 不对的呀。
        // for(int i=0;i<=m;i++)
        
        return res;
    }

    int get(int[] matrix, int i, int j) {
        if(i<0 || i>= m || j<0 || j>=n) {
            return -1;
        }
        if(dp[i][j] != 0) return dp[i][j];
        boolean v1 = false;
        boolean v2 = false;
        for(int[] go: gos) {
            int v = get(matrix, i+go[0], j+go[1]);
            if(v == 1 || v == 3) v1 = true;
            if(v == 2 || v == 3) v2 = true;
        }
        if(v1 && v2) {
            return dp[i][j] = 3;
        }else if(v1) {
            return dp[i][j] = 1;
        }else if(v2) {
            return dp[i][j] = 2;
        }else {
            return dp[i][j] = -1;
        }
    }
}
// @lc code=end

