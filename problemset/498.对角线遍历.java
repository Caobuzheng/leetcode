/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    /**
     * [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[]{};
        int n = matrix[0].length;
        if(n == 0) return new int[]{};
        int[] ans = new int[m*n];
        int x = 0;
        int y = 0;
        int index = 0;
        while(index<m*n) {
            while(index<m*n) {
                ans[index++] = matrix[x][y];
                if(x == 0 || y == n-1) {
                    //
                    if(x == 0 && y != n-1 ) y++;
                    else  x++;
                    break;
                }
                x--;
                y++;
            }
            while(index<m*n) {
                ans[index++] = matrix[x][y];
                if(y == 0 || x == m-1) {
                    if(y == 0 && x != m-1) x++;
                    else y++;
                    break;
                }
                x++;
                y--;
            }
        }
        return ans;
    }
}
// @lc code=end

