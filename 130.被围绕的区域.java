/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public static void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        boolean[][] tag = new boolean[m][n];
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(i==0|| j==0  || i>=m-1 || j>=n-1){
                    markTag(tag, board, i, j);
                }else {
                    continue;
                }
            }
        }
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(!tag[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        return ;
    }
    public static void markTag(boolean[][] tag, char[][] board, int x, int y) {
        if(x<0 || x >= board.length) {
            return;
        }
        if(y<0 || y >= board[0].length) {
            return;
        }
        if(tag[x][y]) return;
        if(board[x][y] == 'O') {
            tag[x][y] = true;
            markTag(tag, board, x+1, y);
            markTag(tag, board, x-1, y);
            markTag(tag, board, x, y+1);
            markTag(tag, board, x, y-1);
        }
    } 
}
// @lc code=end

