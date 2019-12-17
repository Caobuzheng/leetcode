/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[] countA = new int[26];
        int[] countB = new int[26];
        int diff = 0;
        for(int i = 0; i<a.length; i++) {
            char aChar = a[i];
            char bChar = b[i];
            if(aChar != bChar) diff++;
            countA[aChar-'a']++;
            countB[bChar-'a']++;
        }
        if(A.equals(B)) {
            for(int i: countA) if(i>=2) return true;
            return false;
        }
        if(diff == 2) {
            for(int i = 0; i< 26; i++) {
                if(countA[i] != countB[i]) return false;
            }
            return true;
        }
        return false;

    }
}
// @lc code=end

