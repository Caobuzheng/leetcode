/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        return Solution51.solveNQueens(n);
    }
}
class Solution51 {
    static List<List<String>> ans;
    static int[] board;
    static int n;
    public static List<List<String>> solveNQueens(int N) {
        ans = new LinkedList<>();
        n = N;
        board = new int[n+1]; 
        dfs(1);
        return ans;
    }

    static boolean can(int index, int c) {
        for(int i=1;i<index;i++) {
            if(c == board[i]) return false;
            if( Math.abs(index -i) == Math.abs(c-board[i]) ) return false; // 这个地方错了的。
        }
        return true;
    }

    static void dfs(int index) {
        if(index > n) {
            build();
        }
        for(int i = 1;i<=n;i++) {
            if(can(index, i)){
                board[index] = i;
                dfs(index+1);
            }
        }
    }

    static void build() {
        List<String> list = new LinkedList<>();
        for(int i = 1;i<=n;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<=n;j++) {
                if(board[i] == j) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }

}
// @lc code=end

