/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        return Solution59.generateMatrix(n);
    }
}
class Solution59 {
    public static void main(String[] args) {
        int[][] m = generateMatrix(4);
    }
    public static int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        
        int count = 1;
        for(int i = 0; i<n/2;i++) {
            for(int j = i; j < n-i-1; j++) {
                m[i][j] = count++;
            }
            for(int j=i; j < n-i-1;j++) {
                m[j][n-i-1] = count++;
            }
            for(int j=n-i-1; j>i; j--) {
                m[n-i-1][j] = count++;
            }
            for(int j=n-i-1; j>i; j--) {
                m[j][i] = count++;
            }
        }
        if(n%2==1) {
            m[n/2][n/2] = count;
        }
        return m;
    }
}
// @lc code=end

