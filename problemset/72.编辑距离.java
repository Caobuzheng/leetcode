/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        return So72.minDistance(word1, word2);
    }
}
class So72 {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("horse", "ros"));
    }
    /**
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * word1 = "intention", word2 = "execution"
     * 输出: 5
     * 解释:
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public static int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        int len1 = chars1.length;
        char[] chars2 = word2.toCharArray();
        int len2 = chars2.length;
        int max = Math.max(len1, len2);
        if(len1 == 0 || len2 == 0) return max;
        int[][] dp = new int[len1][len2];
        for(int[] tmp: dp) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        // dp[i][j] 表示 word1 前i个 到word2前i个的最小编辑距离。
        int start = 0;
        if(chars1[0] != chars2[0]) start = 1;
        for(int i = 0;i<len1;i++) {
            dp[i][0] = start+i;
        }
        for(int j = 0; j<len2;j++) {
            dp[0][j] = start+j;
        }

        for(int i = 1; i< len1; i++) {
            for(int j = 1; j< len2;j++) {
                if(chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 不对的。
                    int min = max;
//                    min =
                    // 添加，删除，
                    // 可以这么理解，添加跟删除是一个的。
                    // 这种动态规划，还是不会的。太难了。
                    //   * word1 = "intention", word2 = "execution"
                    //     * 输出: 5
                    //     * 解释:
                    //     * intention -> inention (删除 't')
                    //     * inention -> enention (将 'i' 替换为 'e')
                    //     * enention -> exention (将 'n' 替换为 'x')
                    //     * exention -> exection (将 'n' 替换为 'c')
                    //     * exection -> execution (插入 'u')
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[len1-1][len2-1] == -1?max:dp[len1-1][len2-1];
    }
}
// @lc code=end

