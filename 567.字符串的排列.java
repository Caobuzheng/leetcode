//Accepted
// 103/103 cases passed (4 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 93.98 % of java submissions (37.2 MB)
/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 *
 * https://leetcode-cn.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (32.30%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    9.4K
 * Total Submissions: 29K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return CheckInclusion.checkInclusion(s2, s1);
    }
}
class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("eidbaooo", "ab"));
        System.out.println(checkInclusion("eidboaoo", "ab"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() < s2.length() ) return false;
        int[] count = new int[27];
        // init count 
        for(char c: s2.toCharArray()) {
            count[c-'a']++;
        }
        int index = 0;
        char[] chars = s1.toCharArray();
        for(;index<s2.length() ;index++) {
            count[chars[index] - 'a']--;
        }
        if(checkCount(count)) return true;
        int index2 = 0;
        for(;index<chars.length;index++,index2++) {
            int newOne = chars[index] - 'a';
            int oldOne = chars[index2] - 'a';
            count[newOne]--;
            count[oldOne]++;
            if(count[newOne] ==0 && count[oldOne]== 0) {
                if(checkCount(count)) return true;
            }
        }
        return false;
    }

    private static boolean checkCount(int[] count) {
        for(int i:count) {
            if(i!=0) return false;
        }
        return true;
    }
}
// @lc code=end

