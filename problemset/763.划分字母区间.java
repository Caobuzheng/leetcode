/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

 import java.util.*;
// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        return Solution763.partitionLabels(S);
    }
}
class Solution763 {
    public static void main(String[] args) {
        for(int i: partitionLabels("ababcbacadefegdehijhklij")){
            System.out.println(i);
        }
    }
    public static List<Integer> partitionLabels(String S) {
        List<Integer> ans = new LinkedList<>();
        int[] maxIndex = new int[26];
        char[] chars = S.toCharArray();
        for(int i = 0; i<chars.length;i++) {
            maxIndex[chars[i] - 'a'] = i;
        }
        for(int i = 0; i<chars.length;i++) {
            int max = maxIndex[chars[i] - 'a'];
            for(int j = i+1;j< max;j++) {
                max = Math.max(maxIndex[chars[j] - 'a'], max);
            }
            ans.add(max-i+1);
            i = max;
        }
        return ans;
    }
}
// @lc code=end

