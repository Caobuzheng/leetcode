/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        return So72.minDistance(word1, word2);
    }
}
class So72 {
    public static void main(String[] args) {
        System.out.println(minDistance("tion", "tion"));
        System.out.println(minDistance("intention", "exeeution"));
    }
    public static int minDistance(String word1, String word2) {
        // 为啥我没想到动态规划
      return 0;
    }
}
// @lc code=end

