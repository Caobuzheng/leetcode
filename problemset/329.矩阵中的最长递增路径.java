/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        return Solution329.longestIncreasingPath(matrix);
    }
}
class Solution329 {
    static int ans;
    static int[][] dp;
    static int m;
    static int n;
    public static int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m == 0) return 0;
        n = matrix[0].length;
        ans = 0;
        dp = new int[m][n];

        for(int i = 0; i<m;i++) {
            for(int j = 0;j<n;j++) {
                int c = dfs(matrix,i,j, Integer.MIN_VALUE);
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }

    static int dfs(int[][] matrix, int i, int j, int val) {
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j] <= val) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int max = 0;
        int nVal = matrix[i][j];
        max = Math.max(dfs(matrix, i-1,j,nVal),max);
        max = Math.max(dfs(matrix, i+1,j,nVal),max);
        max = Math.max(dfs(matrix, i,j+1,nVal),max);
        max = Math.max(dfs(matrix, i,j-1,nVal),max);
        dp[i][j] = max+1;
        return dp[i][j];
    }
}
// @lc code=end

