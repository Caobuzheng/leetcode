/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 */
import java.util.*;
// @lc code=start
class Solution {
    static public int matrixScore(int[][] A) {
        int  m = A.length;
        if(m == 0) return 0;
        int n = A[0].length;
        if(n == 0) return 0;

        for(int i = 0; i<m;i++) {
            if(A[i][0] == 0) {
                for(int j = 0;j<n;j++) {
                    A[i][j] = 1- A[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            int more = 0;
            for(int j=0;j<m;j++) {
                more += A[j][i];
            }
            if(more<=m/2) {
                for(int j=0;j<m;j++) {
                    A[j][i] = (1-A[j][i]);
                }
            }
        }
        // 能简化这步。
        int count = 0;
        for(int i=0;i<m;i++){
            int more = 0;
            for(int j=0;j<n;j++) {
                more = more *2 + A[i][j];
            }
            count+=more;
        }
        return count;
    }
}

class So861 {
    //
}
// @lc code=end

