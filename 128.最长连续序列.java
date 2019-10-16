/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    // 那么这个算法是O(n2)的。
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
        要求算法的时间复杂度为 O(n)。
        示例:
        输入: [100, 4, 200, 1, 3, 2]
        输出: 4
        解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int max = 1;
        // 我似乎还能用更快的方法？
        // 重新组织下这个[] 然后是余数+结果的。这个怎么组织到List里呢？
        // Map也不是On的啊。
        // 我理解是Map不算作On的。移动的？
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
// @lc code=end

