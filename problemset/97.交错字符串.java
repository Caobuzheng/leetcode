/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    static boolean[][][] mem;
    public static boolean isInterleave(String s1, String s2, String s3) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for(char c: s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for(char c: s2.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if(count<1) return false;
            map.put(c,  count -1);
        }
        mem = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return help(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    public static boolean help(char[] s1, char[] s2, char[] s3, int i1, int i2, int i3) {
        if(i3 == s3.length){
            return i1 == s1.length && i2 == s2.length;
        }
        boolean tag = false;
        if(mem[i1][i2][i3]) {
            return false;
        }
        mem[i1][i2][i3] = true;
        if(s1.length>i1 && s1[i1] == s3[i3]) {
            tag = tag || help(s1, s2 , s3, i1+1, i2 ,i3+1);
        }
        if(s2.length>i2 && s2[i2] == s3[i3]) {
            tag = tag || help(s1, s2 , s3, i1, i2 +1 ,i3+1);
        }
        return tag;
    }
}
// @lc code=end

