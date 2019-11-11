/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        return Solution85.maximalRectangle(matrix);
    }
}

class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
          };
        System.out.println(maximalRectangle(matrix));
          
    }
    public static int maximalRectangle(char[][] matrix) {
        // 
        return 0;
    }

}
// @lc code=end

