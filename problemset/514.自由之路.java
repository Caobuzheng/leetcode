/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */
import java.util.*;
// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        // 其实这个还好的啦。就是左右就行。然后 key是 1-100.那么
        return Solution514.findRotateSteps(ring, key);  
    }
}
class Solution514 {
    public static void main(String[] args) {
        System.out.println(findRotateSteps("abcde", "ade"));
    }
    public static int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length() + 1][ring.length()];
        int ans = Integer.MAX_VALUE;
        int ringLen = ring.length();
        for(int i = 1;i<=key.length();i++) {
            for(int j = 0; j<ring.length();j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for(int rolls = 0; rolls<key.length(); rolls++){
            int size = queue.size();
            Set<Integer> nexts = new HashSet<>();
            char c = key.charAt(rolls);
            for(int i = 0;i<size;i++) {
                int index = queue.poll();
                for(int j=0;j<ring.length();j++) {
                    if(ring.charAt(j) == c) {
                        nexts.add(j);
                        int len = Math.min(Math.min(Math.abs(index + ringLen - j), Math.abs(j - index)), Math.abs(j+ringLen-index)) + 1;
                        dp[rolls+1][j] = Math.min(dp[rolls][index] + len, dp[rolls+1][j]);
                    }
                }
            }
            queue.addAll(nexts);
        }
        for(int i: dp[key.length()]){
            ans = Math.min(ans, i);
        }
        return ans;
    }
}
// @lc code=end

