import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (37.24%)
 * Likes:    230
 * Dislikes: 0
 * Total Accepted:    27.5K
 * Total Submissions: 73.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return Solution54.spiralOrder(matrix);
    }
}
class Solution54 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,1,2},
            {8,9,4,3,4},
            {8,10,4,6,5}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res.stream().map(i->""+i).reduce((i1,i2)->i1+","+i2).get());
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        if(n == 0) return res;
        for(int i = 0; i*2<Math.min(m, n); i++) {
            boolean onlyTop = m-i*2 == 1;
            boolean onlyRight = n-i*2 == 1; 
            
            if(onlyRight && onlyTop) {
                res.add(matrix[i][i]);
            }else if(onlyTop) {
                for(int j=i; j<n-i; j++){
                    res.add(matrix[i][j]);
                }
            }
            else if(onlyRight) {
                for(int j =i; j<m-i; j++){
                    res.add(matrix[j][n-i-1]);
                }
            }else{
                // print top
                for(int j=i; j<n-i-1; j++){
                    res.add(matrix[i][j]);
                }
                // print right;
                for(int j =i; j<m-i-1; j++){
                    res.add(matrix[j][n-i-1]);
                }
                // print bottom and left
                for(int j=n-i-1;j>i;j--) {
                    res.add(matrix[m-i-1][j]);
                }
                for(int j=m-i-1;j>i;j--) {
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }
}
// @lc code=end

