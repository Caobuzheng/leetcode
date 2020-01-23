import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        if(m <3) return 0;
        int n = grid[0].length;
        if(n <3) return 0;
        int ans = 0;
        for(int i = 0; i<=m-3;i++) {
            for(int j = 0; j<=n-3;j++) {
                boolean tag = true;
                int sum = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
               
                boolean[] flag = new boolean[9];
                Arrays.fill(flag,  false);
                if(sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) tag= false;
                for(int k = 0;k<3;k++) {
                    int tmpSum1 = 0;
                    int tmpSum2 = 0;
                    for(int l=0;l<3;l++) {
                        tmpSum1 += grid[i][j+l];
                        if(grid[i+k][j+l] < 10 && grid[i+k][j+l] > 0) {
                            flag[grid[i+k][j+l]-1] = true;
                        }
                        tmpSum2 += grid[i+l][j];
                    }
                    if(tmpSum1 != sum || tmpSum2 != sum) tag = false;
                }

                for(boolean tt: flag) {
                    tag = tag && tt;
                }
                if(tag) ans++;
            }
        }
        return ans;
    }
    // 4 3 8 4
    // 9 5 1 9
    // 2 7 6 2
}
// @lc code=end

