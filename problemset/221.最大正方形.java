/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        return Solution221.maximalSquare(matrix);
    }
}
/**
 *  1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0
    ans = 4
 */
/**
 *  1 1 1 1 0
    1 2 2 2 1
    1 2 3 3 1
    1 2 3 4 0
    ans = 4
 */
class Solution221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int mm = Math.max(m,n);
        int[][] mn = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0; j<n;j++) {
                mn[i][j] = matrix[i][j] - '0';
            }
        }
        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                if(mn[i][j] == 1) {
                    int min = mm;
                    min = Math.min(mn[i-1][j-1], min);
                    min = Math.min(mn[i][j-1], min);
                    min = Math.min(mn[i-1][j], min);
                    mn[i][j] = min+1;
                }
            }
        }        
        int max = 0;
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n; j++) {
                max = Math.max(max, mn[i][j]);
            }
        }
        return max*max;   
    }
}
// @lc code=end

