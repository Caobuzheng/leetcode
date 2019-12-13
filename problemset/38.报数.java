/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 * todo
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String[] ans = new String[31];
        ans[1] = "1";
        ans[2] = "11";
        ans[3] = "21";
        ans[4] = "1211";
        for(int i = 4; i<n ;i ++) {
            String next = buildNext(ans[i]);
            ans[i+1] = next;
        }
        return ans[n];
    }
    private static String buildNext(String w) {
        char[] chars = w.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < chars.length) {
            if(i<chars.length-1 && chars[i] == chars[i+1]) {
                int count = 0;
                char c = chars[i];
                while(i<chars.length && chars[i] == c){
                    i++;
                    count++;
                }
                sb.append(count);
                sb.append(c);
            }else {
                sb.append(1);
                sb.append(chars[i]);
                i++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

