/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        return Solution85.maximalRectangle(matrix);
    }
}

class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
          };
        System.out.println(maximalRectangle(matrix));
          
    }
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int max = 0;
        int[][][] dp = new int[m][n][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = new int[]{0, 0};
                }else {
                    int[] ij = dp[i][j];
                    if(i==0){
                        ij[0] = 1;
                    }else {
                        ij[0] = dp[i-1][j][0] + 1;
                    }
                    if(j==0) {
                        ij[1] = 1;
                    }else {
                        ij[1] = dp[i][j-1][1] + 1;
                    }
                    max = Math.max(Math.max(ij[0], ij[1]), max);
                    int with = ij[1];
                    int ii = i-1;
                    while(with >1 && ii >=0) {
                        if(dp[ii][j][1] > 1) {
                            with = Math.min(with, dp[ii][j][1]);
                            max = Math.max((i-ii + 1) * with, max);
                            ii--;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }

}
// @lc code=end

