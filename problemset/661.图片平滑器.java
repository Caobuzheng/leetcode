/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        if(m == 0) return null;
        int n = M[0].length;
        if(n == 0) return null;
        int[][] ans = new int[m][n];

        for(int i = 0; i< m; i++) {
            for(int j = 0;j<n; j++) {
                int sum = 0;
                int count = 0;
                for(int x=-1;x<=1;x++) {
                    for(int y=-1;y<=1;y++) {
                        int xx = x+i;
                        int yy = y+j;
                        if(xx >=0 && xx < m && yy>=0 && yy<n){
                            sum+= M[xx][yy];
                            count++;
                        }
                    }
                }
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}
// @lc code=end

