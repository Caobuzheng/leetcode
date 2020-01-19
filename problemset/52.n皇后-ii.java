/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */
import java.util.*;
// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        return Solution52.totalNQueens(n);
    }
}

class Solution52 {
    static int[] board;
    static int ans;
    static int n;
    public static int totalNQueens(int N) {
        ans = 0;
        n = N;
        board = new int[n+1]; 
        dfs(1);
        return ans;
    }

    static boolean can(int index, int c) {
        for(int i=1;i<index;i++) {
            if(c == board[i]) return false;
            if( Math.abs(index -i) == Math.abs(c-board[i]) ) return false;
        }
        return true;
    }

    static void dfs(int index) {
        if(index > n) {
            ans++;
        }
        for(int i = 1;i<=n;i++) {
            if(can(index, i)){
                board[index] = i;
                dfs(index+1);
            }
        }
    }
}
// @lc code=end

