import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int i:nums) {
            set.add(i);
        }
        for(int i: nums) {
            if(set.contains(i-1)) {
                continue;
            }else {
                int j = i+1;
                while(set.contains(j)){
                    j++;
                }
                max = Math.max(max, j-i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(longestConsecutive(nums));
    }
}
// @lc code=end

