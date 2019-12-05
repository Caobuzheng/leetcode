/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 */

// @lc code=start
class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        return Solution807.maxIncreaseKeepingSkyline(grid);
    }
}

class Solution807 {
    public static void main(String[] args) {
        // result = 35
        // grid = 
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int[] left = new int[m];
        int[] top = new int[n];
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++) {
                left[i] = Math.max(left[i], grid[i][j]);
                top[j] =  Math.max(top[j], grid[i][j]);
            }
        }
        // 错了的？
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++) {
                ans += Math.min(left[i], top[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end

