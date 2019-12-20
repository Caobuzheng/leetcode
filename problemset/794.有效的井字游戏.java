/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        // 这个比较简单。
        int countO = 0;
        int countX = 0;
        int[][] bo = new int[3][3];
        for(int i = 0;i<board.length;i++) {
            for(int j = 0; j< 3;j++) {
                char c = board[i].charAt(j);
                if( c == 'O') {
                    countO++;
                    bo[i][j] = 2;
                }else if (c == 'X') {
                    countX++;
                    bo[i][j] = 1;
                }else {
                    bo[i][j] = 0;
                }
            }
        } 
        int diff = countX - countO;
        if( diff>1 || diff<0) return false;
        int midmid = bo[1][1];
        int tag = 0;
        if(bo[0][0] == midmid && bo[2][2] == midmid && midmid != 0) {
            tag = midmid;
        }
        if(bo[0][2] == midmid && bo[2][0] == midmid && midmid != 0) {
            tag = midmid;
        }
        int x = 0;
        int y = 0;
        for(int i = 0; i< 3;i++) {
            if(bo[i][0] == bo[i][1] && bo[i][1]== bo[i][2] && bo[i][1] !=0) {
                tag = bo[i][0];
                x++;
            }
            if(bo[0][i] == bo[1][i] && bo[1][i]== bo[2][i] && bo[2][i] != 0) {
                y++;
                tag = bo[0][i];
            }
        }
        if(x>1 || y > 1) return false;
        if(tag == 1 && diff==0 && (countO+countX != 9)) return false; 
        if(tag == 2 && diff==1 ) return false; 
        return true;
    }
}
// @lc code=end

