/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.86%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    19.4K
 * Total Submissions: 88.4K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 如果是0的话，就直接return
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        return NumDecodingsDp.numDecodings(s);
    }
}
// 没写对，果然还是递归的比dp的好写。
class NumDecodingsDp {
    public static void main(String[] args) {
        // System.out.println(numDecodings("213")); //3 
        // System.out.println(numDecodings("2341"));//2
        // System.out.println(numDecodings("12"));//2
        System.out.println(numDecodings("0"));//2
    }
    // [1,1,0,0] -> 
    public static int numDecodings(String s) {
        if(s.length() == 0) return 1;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length+1];
        dp[0] = 1;
        if(chars[0] != '0') {
            dp[1] = 1;
        }
        for(int i=1; i<chars.length;i++) {
            if(chars[i] != '0') {
                dp[i+1] += dp[i];
            }
            if(chars[i-1] != '0') {
                int val = (chars[i-1] - '0') * 10 + chars[i] - '0';
                if(val >0 && val <=26) {
                    dp[i+1] += dp[i-1];
                }
            }
        }
        return dp[chars.length];
    }
}
class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
    static Integer ans = 0;
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        ans = 0;
        helper(chars, 0);
        return ans;
    }
    public static void helper(char[] chars, int index) {
        if(index == chars.length) {
            ans = ans+1;
            return;
        }
        int tmp = chars[index]-'0';
        if(tmp == 0) return;
        helper(chars, index+1);
        if(index<chars.length-1){
            if(tmp*10+chars[index+1]-'0' <= 26) {
                helper(chars, index+2);
            }
        }
    }
}
// @lc code=end

