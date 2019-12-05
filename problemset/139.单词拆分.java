/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return Solution139.wordBreak(s, wordDict);
    }
}
class Solution139 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats"); 
        wordDict.add("dog"); 
        wordDict.add("sand"); 
        wordDict.add("and"); 
        wordDict.add("cat"); 
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i<dp.length;i++) {
            if(!dp[i]) continue;
            for(String str: wordDict) {
                int length = str.length();
                if(i+length >= dp.length || dp[i+length]) continue;
                if(s.substring(i, i+length).equals(str)) dp[i+length] = true;
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

